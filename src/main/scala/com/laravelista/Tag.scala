package com.laravelista

import scalatags.Text.TypedTag
import scalatags.Text.all.s

enum Tag(val tag: String):
  case WebShop extends Tag("web-shop")
  case BusinessApp extends Tag("business-app")
  case DirectoryListing extends Tag("directory-listing")
  case BookingSystem extends Tag("booking-system")
  case CustomSoftware extends Tag("custom-software")
  case WebStandard extends Tag("web-standard")

  def getSvg: TypedTag[String] =
    this match
      case WebShop          => svgs.webShop
      case BusinessApp      => svgs.businessApp
      case DirectoryListing => svgs.directoryListing
      case BookingSystem    => svgs.bookingSystem
      case CustomSoftware   => svgs.customSoftware
      case WebStandard      => svgs.webStandard

  override def toString: String =
    s"#$tag"

object Tag:
  def from(value: String) =
    this.values.find(_.tag == value)
