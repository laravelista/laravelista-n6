package com.laravelista.js

import org.scalajs.dom.{
  Element,
  Event,
  EventTarget,
  MediaQueryList,
  MediaQueryListListener,
  MouseEvent,
  document,
  window,
  HTMLCollection
}

val darkClass = "dark"
val lightClass = "light"
val hiddenClass = "hidden"

trait ThemeInterface:
  val automaticSvg: Element
  val darkSvg: Element
  val lightSvg: Element
  val prefersDark: MediaQueryList

def getLocalStorageTheme = window.localStorage.getItem("theme")

def addDarkClassToBody(): Unit =
  document.documentElement.classList.add(darkClass)

def removeDarkClassFromBody(): Unit =
  document.documentElement.classList.remove(darkClass)

def setLightTheme(theme: ThemeInterface): Unit =
  import theme.*

  removeDarkClassFromBody()

  automaticSvg.classList.add(hiddenClass)
  darkSvg.classList.add(hiddenClass)
  lightSvg.classList.remove(hiddenClass)

def setDarkTheme(theme: ThemeInterface): Unit =
  import theme.*

  addDarkClassToBody()

  automaticSvg.classList.add(hiddenClass)
  darkSvg.classList.remove(hiddenClass)
  lightSvg.classList.add(hiddenClass)

def setAutomaticTheme(theme: ThemeInterface, darkTheme: Boolean = false): Unit =
  import theme.*

  automaticSvg.classList.remove(hiddenClass)
  darkSvg.classList.add(hiddenClass)
  lightSvg.classList.add(hiddenClass)

  if darkTheme then addDarkClassToBody()
  else removeDarkClassFromBody()

def setupMobileNavbarToggle(): Unit =
  val mobileNavbar = document.getElementById("mobile-navbar")
  val mobileNavbarToggle = document.getElementById("mobile-navbar-toggle")

  mobileNavbarToggle.addEventListener(
    "click",
    (_: MouseEvent) => mobileNavbar.classList.toggle(hiddenClass)
  )

// Flow: automatic -> dark -> light
def enableThemeSwitching(theme: ThemeInterface): Unit =
  val themeSwitchButton = document.getElementById("theme-switch")

  themeSwitchButton.addEventListener(
    "click",
    (_: MouseEvent) =>
      val localStorageTheme = getLocalStorageTheme

      // automatic -> dark
      if localStorageTheme == null then
        setDarkTheme(theme)

        // Whenever the user explicitly chooses dark mode
        window.localStorage.setItem("theme", darkClass)

      // dark -> light
      else if localStorageTheme == darkClass then
        setLightTheme(theme)

        // Whenever the user explicitly chooses light mode
        window.localStorage.setItem("theme", lightClass)

      // light -> automatic (dark/light)
      else if localStorageTheme == lightClass then
        if theme.prefersDark.matches then
          setAutomaticTheme(theme, darkTheme = true)
        else setAutomaticTheme(theme)

        // Whenever the user explicitly chooses to respect the OS preference
        window.localStorage.removeItem("theme")
  )

def applyTheme(theme: ThemeInterface): Unit =
  val localStorageTheme = getLocalStorageTheme

  if localStorageTheme == lightClass then setLightTheme(theme)
  else if localStorageTheme == darkClass then setDarkTheme(theme)
  else if theme.prefersDark.matches then
    setAutomaticTheme(theme, darkTheme = true)
  else setAutomaticTheme(theme)

def detectThemeChange(theme: ThemeInterface): Unit =
  theme.prefersDark
    .asInstanceOf[EventTarget]
    .addEventListener(
      "change",
      (e: MediaQueryList) =>
        val localStorageTheme = getLocalStorageTheme

        localStorageTheme match
          case null =>
            if e.matches then setAutomaticTheme(theme, darkTheme = true)
            else setAutomaticTheme(theme)
          case _ => ()
    )

def setupThemeSwitcher(prefersDark0: MediaQueryList): Unit =
  object Theme extends ThemeInterface:
    val automaticSvg: Element = document.getElementById("theme-automatic")
    val darkSvg: Element = document.getElementById("theme-dark")
    val lightSvg: Element = document.getElementById("theme-light")
    val prefersDark: MediaQueryList = prefersDark0

  applyTheme(Theme)

  detectThemeChange(Theme)

  enableThemeSwitching(Theme)

@main def Main(): Unit =
  val localStorageTheme = getLocalStorageTheme
  val prefersDark = window.matchMedia("(prefers-color-scheme: dark)")

  if localStorageTheme == lightClass then removeDarkClassFromBody()
  else if localStorageTheme == darkClass then addDarkClassToBody()
  else if prefersDark.matches then addDarkClassToBody()
  else removeDarkClassFromBody()

  document.addEventListener(
    "DOMContentLoaded",
    (_: Event) =>
      setupMobileNavbarToggle()
      setupThemeSwitcher(prefersDark)
  )
