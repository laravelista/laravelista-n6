package com.laravelista

case class SesConfig(key: String, secret: String, region: String = "eu-west-1")

object Config:
  val analyticsEnabled = sys.env.getOrElse("ANALYTICS_ENABLED", "false") match
    case "true" => true
    case _      => false

  val ses = SesConfig(
    key = sys.env.getOrElse("AWS_SES_KEY", ""),
    secret = sys.env.getOrElse("AWS_SES_SECRET", "")
  )

  val emailAddress = "mario@laravelista.com"
  val replyToAddress = "mario@laravelista.com"
