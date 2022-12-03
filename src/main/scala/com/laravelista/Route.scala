package com.laravelista

import org.http4s.dsl.io.*

enum Route(val name: String, val url: Path):
  case Home extends Route("Home", url = Root)
  case References extends Route("Portfolio", url = Root / "portfolio")
  case Contact extends Route("Contact", url = Root / "contact")
  case PrivacyNotice
      extends Route("Privacy notice", url = Root / "privacy-notice")
