package com.laravelista

import java.net.URL
import java.net.URI
import java.net.Proxy

case class Reference(
    name: String,
    tag: Tag,
    url: Option[URL] = None,
    featured: Boolean = false,
    yearMade: Int,
    description: String
)

object Reference:
  def getUrl(reference: Reference): URL =
    reference.url match
      case Some(url) => url
      case None      => URI.create("#").toURL()

val references =
  import Tag.*

  List(
    Reference(
      "OPG Paić",
      WebStandard,
      Some(URI.create("https://opg-paic.hr").toURL()),
      featured = true,
      yearMade = 2023,
      description =
        "Website for a family run olive oil production farm. Built with a custom made PHP framework."
    ),
    Reference(
      "Kikolina",
      WebShop,
      Some(URI.create("https://kikolina.hr").toURL()),
      featured = true,
      yearMade = 2022,
      description =
        "Webshop for a nail salon and nail care products made with Laravel. Uses self made sponsorware laravel packages."
    ),
    Reference(
      "Bonaventura",
      BookingSystem,
      Some(URI.create("https://bonaventura.vip").toURL()),
      featured = true,
      yearMade = 2022,
      description =
        "Booking system web application made with Laravel, TailwindCSS, Alpine.js and Laravel Livewire."
    ),
    Reference(
      "Quad Murter Kornati",
      WebStandard,
      Some(URI.create("https://quad-murterkornati.com").toURL()),
      yearMade = 2022,
      description =
        "Rent a Quad in Murter website made with vanilla PHP and Composer with no other dependencies."
    ),
    Reference(
      "Jet Ski Murter Kornati",
      WebStandard,
      Some(URI.create("https://jetski-murterkornati.com").toURL()),
      yearMade = 2021,
      description =
        "Modern Rent a Jet Ski in Murter website made with vanilla PHP and Composer with no other dependencies."
    ),
    Reference(
      "Meling Gradnja",
      CustomSoftware,
      Some(URI.create("https://meling-gradnja.hr/").toURL()),
      yearMade = 2021,
      description =
        "Website for a construction company made with Laravel. Uses self made sponsorware laravel packages."
    ),
    Reference(
      "Stay in Adriatic",
      CustomSoftware,
      Some(URI.create("https://stayinadriatic.com").toURL()),
      featured = true,
      yearMade = 2020,
      description =
        "Accommodation booking website made with Laravel and integrated with an external booking system Rentl.io."
    ),
    Reference(
      "Futurista",
      CustomSoftware,
      Some(URI.create("https://futurista.hr/").toURL()),
      yearMade = 2020,
      description =
        "Company website/blog made with Laravel. Design adapted from a Ghost blog template. Uses self made sponsorware blog laravel package."
    ),
    Reference(
      "Private transfers \"Karoca\"",
      CustomSoftware,
      Some(URI.create("https://taxiotokmurter.com/").toURL()),
      yearMade = 2019,
      description =
        "Company website for booking private transfers made with Laravel."
    ),
    Reference(
      "Butcher shop \"Milina\"",
      WebStandard,
      Some(URI.create("https://milina.hr/").toURL()),
      yearMade = 2019,
      description =
        "Simple one-page company website for a butcher shop made with Laravel."
    ),
    Reference(
      "Go Visit",
      WebStandard,
      Some(URI.create("https://govisit.hr/").toURL()),
      yearMade = 2018,
      description = "Company website for a software company made with Laravel."
    ),
    Reference(
      "Shipyard \"Ćiro\"",
      WebStandard,
      Some(URI.create("https://brodogradiliste-ciro.hr/").toURL()),
      yearMade = 2018,
      description = "Company website for shipyard Ćiro made with Grav CMS."
    ),
    Reference(
      "Damex",
      WebStandard,
      Some(URI.create("https://damex.hr/").toURL()),
      yearMade = 2018,
      description =
        "Simple company website for a bookkeeping business made with HTML, CSS and PHP."
    ),
    Reference(
      "Dragan Bašić",
      WebStandard,
      Some(URI.create("https://draganbasic.com/").toURL()),
      yearMade = 2018,
      description =
        "Personal website/portfolio for house construction made with Grav CMS."
    ),
    Reference(
      "VisitMurter",
      DirectoryListing,
      Some(URI.create("https://visitmurter.hr").toURL()),
      featured = true,
      yearMade = 2017,
      description =
        "Tourist information portal, API and android/ios mobile application made with Laravel and React-native."
    ),
    Reference(
      "Car service \"Antušina\"",
      WebStandard,
      Some(URI.create("https://antusina.hr/").toURL()),
      yearMade = 2017,
      description = "Car service company website made with Laravel."
    ),
    Reference(
      "Apartments \"Milina\"",
      WebStandard,
      Some(URI.create("https://apartmanimilina.com/").toURL()),
      yearMade = 2017,
      description = "Apartment booking website made with Laravel."
    ),
    Reference(
      "Adriatica Consult",
      WebStandard,
      Some(URI.create("http://adriaticaconsult.com/").toURL()),
      yearMade = 2016,
      description =
        "Business consulting company one-page website made with Laravel."
    ),
    Reference(
      "Studio \"Renata\"",
      WebStandard,
      Some(URI.create("http://studio-renata.hr/").toURL()),
      yearMade = 2016,
      description = "Hair salon company one-page website made with Laravel."
    ),
    Reference(
      "Real estate agency \"Treva\"",
      CustomSoftware,
      Some(URI.create("https://nekretnine-treva.com/").toURL()),
      yearMade = 2016,
      description = "Real estate agency website made with Laravel."
    ),
    Reference(
      "Apartments \"Kornat\"",
      CustomSoftware,
      Some(URI.create("https://apartmani-kornat.com/").toURL()),
      yearMade = 2015,
      description = "Apartment booking website made with Laravel."
    ),
    Reference(
      "Apartments \"Slanica\"",
      CustomSoftware,
      Some(URI.create("https://murter-apartments.com/").toURL()),
      yearMade = 2015,
      description = "Apartment booking website made with Laravel."
    ),
    Reference(
      "Villa \"Moj San\"",
      CustomSoftware,
      Some(URI.create("http://apartmani-zablace.com/").toURL()),
      yearMade = 2015,
      description = "Apartment booking website made with OctoberCMS."
    ),
    Reference(
      "G.I.M. Gase",
      BusinessApp,
      Some(URI.create("https://gimgase.hr").toURL()),
      featured = true,
      yearMade = 2015,
      description =
        "Web application made with Laravel and React.js for fire-extinguisher repair and business intelligence."
    ),
    Reference(
      "Dance studio \"Plesni Koraci\"",
      WebStandard,
      Some(URI.create("https://plesnikoraci.com/").toURL()),
      yearMade = 2014,
      description =
        "Company website for dance lessons and dance shows made with Laravel."
    ),
    Reference(
      "Hotel \"Murter\"",
      CustomSoftware,
      Some(URI.create("https://hotelmurter.com/").toURL()),
      yearMade = 2014,
      description =
        "Company website for a hotel in Murter made with Laravel. Integrated external service Rentlio for room bookings."
    ),
    Reference(
      "Real estate agency \"Adriatica\"",
      CustomSoftware,
      Some(URI.create("https://adriatica-nekretnine.hr/").toURL()),
      yearMade = 2014,
      description =
        "Real estate agency website made with Laravel. Integrated external service Crozilla for property marketing."
    ),
    Reference(
      "Tourist agency \"Murterin\"",
      CustomSoftware,
      Some(URI.create("https://murterin.com/").toURL()),
      yearMade = 2013,
      description =
        "Company website for a tourist agency made with Laravel. Consists of two Laravel applications: one API/CMS and one Website."
    ),
    Reference(
      "Real estate agency \"Duos\"",
      CustomSoftware,
      Some(URI.create("https://duos-croatia.com/").toURL()),
      yearMade = 2013,
      description =
        "Real estate agency website made with Laravel. Integrated external service iRealOne for property management."
    ),
    Reference(
      "Online store \"Daba\"",
      WebShop,
      Some(URI.create("https://daba.hr/").toURL()),
      yearMade = 2013,
      description =
        "Webshop for a woodworking company in Murter made with Laravel."
    ),
    Reference(
      "Virmanix",
      BusinessApp,
      Some(URI.create("https://virmanix.damex.hr/").toURL()),
      yearMade = 2013,
      description =
        "Business web application for printing virmans for a bookkeeping company made with Laravel."
    ),
    Reference(
      "Villa \"Renata\"",
      WebStandard,
      Some(URI.create("https://firstclassmurter.com/").toURL()),
      yearMade = 2012,
      description = "Apartment renting website made with Joomla."
    ),
    Reference(
      "Attorney \"Vjeran Paić\"",
      WebStandard,
      Some(URI.create("https://odvjetnik-vjeran-paic.com/").toURL()),
      yearMade = 2011,
      description = "Attorney at law website made with Joomla."
    )
  )
