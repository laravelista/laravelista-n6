package com.laravelista.pages

import scalatags.Text.all.*
import scalatags.Text.attrs.src
import scalatags.Text.tags.br
import scalatags.Text.svgTags.{path, svg}
import scalatags.Text.svgAttrs.{d, viewBox, fill}
import com.laravelista.layouts.defaultLayout
import com.laravelista.{Route, Reference, Tag, references, svgs}
import com.laravelista.partials.renderReferences
import com.laravelista.typography as typo
import scalatags.Text.TypedTag

import java.net.URL

enum CtaButtonSize(val classes: String):
  case Medium extends CtaButtonSize("py-2 px-4")
  case Large extends CtaButtonSize("py-4 px-7")

val ctaButtonClasses =
  "font-medium bg-black dark:bg-white text-zinc-100 dark:text-zinc-900 rounded-lg inline-block hover:bg-zinc-700 dark:hover:bg-zinc-200 duration-300"

def ctaButton(
    text: String,
    path: String,
    size: CtaButtonSize = CtaButtonSize.Large,
    targetBlank: Boolean = false,
    includeRel: Boolean = false
) =
  a(
    href := path,
    text,
    cls := s"${ctaButtonClasses} ${size.classes}",
    if targetBlank == true then target := "_blank",
    if includeRel then rel := "nofollow noopener"
  )

val heroTitle = "Full-Stack Freelance Programmer"

val heroLead =
  "Specialized in PHP, Laravel, Javascript, Typescript, Next.js, NestJS, TALL stack, Scala, F#, Phel, React.js, React-native, Vue.js and Nx."

val heroSection =
  div(
    cls := "box relative w-full p-12 bg-zinc-100 dark:bg-zinc-900 text-zinc-700 dark:text-zinc-100 mb-10 mt-10 rounded-lg hover:before:opacity-100 duration-300",
    h1(
      cls := "lg:text-8xl md:text-6xl text-4xl mb-6 font-medium",
      heroTitle
    ),
    p(
      cls := "mb-8 max-w-xl md:text-lg",
      heroLead
    ),
    p(
      cls := "text-right",
      ctaButton("Ready for hire!", Route.Contact.url.toString)
    )
  )

val bookSection =
  div(
    cls := "w-full my-24 md:flex gap-6",
    div(
      cls := "md:w-1/2",
      div(
        cls := "text-xl md:text-2xl uppercase font-extrabold text-zinc-500 dark:text-zinc-200 mb-2",
        "Self-published Book"
      ),
      h2(
        cls := "text-4xl md:text-5xl lg:text-6xl mb-6",
        "A Collection of Laravel Tutorials"
      ),
      p(
        cls := "mb-12 max-w-2xl",
        "This book contains all tutorials that have been published on Laravelista website in the period from >= 2016. to < 2018. This book represents my two year effort to teach others build web sites and web applications using the Laravel framework."
      ),
      p(
        cls := "flex items-center gap-4",
        ctaButton(
          "Find out more",
          "https://mariobasic.com/a-collection-of-laravel-tutorials",
          targetBlank = true,
          includeRel = false
        ),
        typo.outboundLink(
          "Buy on Leanpub",
          URL("https://leanpub.com/laravelista-collection")
        )
      )
    ),
    div(
      cls := "md:w-1/2 flex items-center mt-10 lg:mt-0",
      figure(
        cls := "box relative w-full p-12 bg-zinc-100 dark:bg-zinc-900 text-zinc-700 dark:text-zinc-100 mb-10 mt-10 rounded-lg hover:before:opacity-100 hover:scale-[1.01] duration-300",
        h3(cls := "text-xl mb-4", "Reader testimonial"),
        p(cls := "uppercase font-light mb-2", "Clear and easy"),
        blockquote(
          """"The book is clear and easy to understand, I found some useful stuff like setting up Laravel on shared hosting, RSS, and sitemap.""""
        ),
        figcaption(cls := "mt-1 font-medium", "— Marcel Pow")
      )
    )
  )

def bwCard(
    title: String,
    subtitle: String,
    icon: String,
    link: Option[URL] = None
) =
  val content =
    Seq(
      raw(icon),
      div(
        h3(cls := "text-md lg:text-lg font-medium", title),
        div(
          cls := "text-sm",
          subtitle
        )
      )
    )

  div(
    cls := "w-full bg-zinc-100 dark:bg-zinc-900 rounded-lg box relative px-6 py-4 z-10 hover:before:opacity-100 duration-300 hover:scale-[1.01]",
    link match
      case Some(url) =>
        a(
          href := url.toString,
          cls := "flex",
          target := "_blank",
          rel := "nofollow noopener",
          content
        )
      case None =>
        div(cls := "flex", content)
  )

val sponsorwareSection =
  div(
    cls := "w-full my-24 md:flex gap-6",
    div(
      cls := "md:w-1/2",
      div(
        cls := "text-xl md:text-2xl uppercase font-extrabold text-zinc-500 dark:text-zinc-200 mb-2",
        "Sponsorware"
      ),
      h2(
        cls := "text-4xl md:text-5xl lg:text-6xl mb-6",
        "Private Packages"
      ),
      p(
        cls := "mb-6 max-w-xl",
        "Creating, maintaining and adding new features to open-source packages takes a considerable amount of time. I plan to use the funds obtained from this sponsorship to support my open-source work."
      ),
      ul(
        cls := "list-disc list-inside mb-12",
        li(
          cls := "my-2",
          typo.outboundLink(
            "Backers",
            URL("https://mariobasic.com/backers"),
            includeRel = false
          )
        )
      ),
      p(
        cls := "flex items-center gap-4",
        ctaButton(
          "Become a sponsor",
          "https://github.com/sponsors/mabasic",
          targetBlank = true,
          includeRel = true
        ),
        typo.outboundLink("Explore", URL("https://packages.laravelista.com"))
      )
    ),
    div(
      cls := "md:w-1/2",
      div(
        cls := "grid grid-cols-1 sm:grid-cols-2 md:grid-cols-1 lg:grid-cols-1 xl:grid-cols-2 gap-6 w-full mt-24 md:mt-10",
        bwCard(
          "laravelista/algo",
          "Multilingual blog package for Laravel.",
          svgs.laravelLogo
        ),
        bwCard(
          "laravelista/localized",
          "Localized routes package for Laravel.",
          svgs.laravelLogo
        )
      )
    )
  )

val opensourceSection =
  div(
    cls := "w-full my-24 md:flex gap-6",
    div(
      cls := "md:w-1/2",
      div(
        cls := "text-xl md:text-2xl uppercase font-extrabold text-zinc-500 dark:text-zinc-200 mb-2 flex justify-between",
        "Open-Source"
      ),
      h2(
        cls := "text-4xl md:text-5xl lg:text-6xl mb-6",
        "Popular Packages"
      ),
      p(
        cls := "mb-6 max-w-xl",
        "My passion is programming and I love contributing to open source either by writing packages/libraries or improving the open source projects that I use."
      ),
      ul(
        cls := "list-disc list-inside mb-12",
        li(
          cls := "my-2",
          typo.outboundLink(
            "Code of Conduct",
            URL("https://mariobasic.com/code-of-conduct"),
            includeRel = false
          )
        ),
        li(
          cls := "my-2",
          typo.outboundLink(
            "Contributing",
            URL("https://mariobasic.com/contributing"),
            includeRel = false
          )
        )
      ),
      p(
        cls := "flex items-center gap-4",
        ctaButton(
          "GitHub profile",
          "https://github.com/laravelista",
          targetBlank = true,
          includeRel = true
        )
      )
    ),
    div(
      cls := "md:w-1/2",
      div(
        cls := "grid grid-cols-1 sm:grid-cols-2 md:grid-cols-1 lg:grid-cols-1 xl:grid-cols-2 gap-6 w-full mt-24 md:mt-10",
        bwCard(
          "laravelista/Ekko",
          "PHP package for marking navigation items active.",
          svgs.phpLogo,
          Some(URL("https://github.com/laravelista/Ekko"))
        ),
        bwCard(
          "laravelista/comments",
          "Native comments for your Laravel application.",
          svgs.laravelLogo,
          Some(URL("https://github.com/laravelista/comments"))
        ),
        bwCard(
          "laravelista/loki",
          "Laravel localization almost done the right way.",
          svgs.laravelLogo,
          Some(URL("https://github.com/laravelista/loki"))
        ),
        bwCard(
          "laravelista/picasso",
          "Laravel Image Management and Optimization Package.",
          svgs.laravelLogo,
          Some(URL("https://github.com/laravelista/picasso"))
        )
      )
    )
  )

trait Item:
  val name: String
  val tag: Tag
  val description: Option[String]
  val descriptionHtml: Option[ConcreteHtmlTag[String]]

case class Service(
    name: String,
    tag: Tag,
    description: Option[String] = None,
    descriptionHtml: Option[ConcreteHtmlTag[String]] = None
) extends Item

val services =
  import com.laravelista.Tag.*

  List(
    Service(
      name = "Websites",
      tag = WebStandard
    ),
    Service(
      name = "Custom software",
      tag = CustomSoftware
    ),
    Service(
      name = "Business applications",
      tag = BusinessApp
    )
  )

case class Product(
    name: String,
    tag: Tag,
    description: Option[String] = None,
    descriptionHtml: Option[ConcreteHtmlTag[String]] = None
) extends Item

val products =
  import com.laravelista.Tag.*

  List(
    Product(
      name = "Web Shop",
      descriptionHtml = Some(
        span(
          "In accordance with the Croatian law and in cooperation with the ",
          typo.outboundLink("Paušalko", URL("https://pausalko.com")),
          " service for small business invoice handling, here is your own online store fully adapted to your needs."
        )
      ),
      tag = WebShop
    ),
    Product(
      name = "Booking System",
      description = Some(
        "Renting apartments or a house and do not want to depend on other booking services? Here is your own website for attracting guests and a booking management system in one place."
      ),
      tag = BookingSystem
    ),
    Product(
      name = "Directory Listing",
      description = Some(
        "A geographic information system (GIS) with a content management system (CMS), an interactive website and a mobile application. Can be applied to various areas."
      ),
      tag = DirectoryListing
    )
  )

def itemSection(title: String, items: List[Item]) =
  div(
    cls := "flex flex-col my-24",
    div(
      cls := "text-xl md:text-2xl uppercase font-extrabold text-zinc-700 dark:text-zinc-100 mb-2",
      h2(title)
    ),
    p(
      cls := "mb-3.5",
      "Complete turn-key solutions ready for immediate use"
    ),
    div(
      cls := "grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-12 w-full mt-10",
      for item <- items
      yield div(
        cls := "box relative p-12 bg-zinc-100 dark:bg-zinc-900 rounded-lg hover:scale-[1.01] duration-300 hover:before:opacity-100",
        div(
          cls := "flex",
          item.tag.getSvg,
          div(
            h3(cls := "text-lg", item.name),
            div(
              cls := "text-xs",
              item.tag.toString
            )
          )
        ),
        div(
          cls := "mt-5 pb-5",
          item.descriptionHtml match
            case Some(description) => description
            case None =>
              item.description match
                case Some(description) => description
                case None              => ""
        ),
        div(
          cls := "flex items-center justify-end ml-auto mt-4",
          ctaButton(
            "Contact me",
            Route.Contact.url.toString + s"?subject=${item.tag.tag}",
            CtaButtonSize.Medium
          )
        )
      )
    )
  )

val featuredReferences =
  renderReferences(
    references
      .filter(_.featured)
      .sortBy(_.name)
      .reverse
      .sortBy(_.yearMade)
      .reverse
      .take(6),
    "Featured Projects",
    isFeatured = true
  )

val home = Seq(
  heroSection,
  sponsorwareSection,
  itemSection("Products", products),
  opensourceSection,
  featuredReferences,
  bookSection
)

def homePage = defaultLayout(
  home,
  activeRoute = Some(Route.Home),
  metaTitle = heroTitle,
  metaDescription = Some(
    heroLead
  ),
  canonicalUrl = Some(Route.Home.url)
)
