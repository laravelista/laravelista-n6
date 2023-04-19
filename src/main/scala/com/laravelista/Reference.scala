package com.laravelista

import java.net.URL
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
      case None      => URL("#")

val references =
  import Tag.*

  List(
    Reference(
      "OPG Paić",
      WebStandard,
      Some(URL("https://opg-paic.hr")),
      featured = true,
      yearMade = 2023,
      description =
        "Website for a family run olive oil production farm. Built with a custom made PHP framework."
    ),
    Reference(
      "Kikolina",
      WebShop,
      Some(URL("https://kikolina.hr")),
      featured = true,
      yearMade = 2022,
      description =
        "Webshop for a nail salon and nail care products made with Laravel. Uses self made sponsorware laravel packages."
    ),
    Reference(
      "Bonaventura",
      BookingSystem,
      Some(URL("https://bonaventura.vip")),
      featured = true,
      yearMade = 2022,
      description =
        "Booking system web application made with Laravel, TailwindCSS, Alpine.js and Laravel Livewire."
    ),
    Reference(
      "Quad Murter Kornati",
      WebStandard,
      Some(URL("https://quad-murterkornati.com")),
      yearMade = 2022,
      description =
        "Rent a Quad in Murter website made with vanilla PHP and Composer with no other dependencies."
    ),
    Reference(
      "Jet Ski Murter Kornati",
      WebStandard,
      Some(URL("https://jetski-murterkornati.com")),
      yearMade = 2021,
      description =
        "Modern Rent a Jet Ski in Murter website made with vanilla PHP and Composer with no other dependencies."
    ),
    Reference(
      "Meling Gradnja",
      CustomSoftware,
      Some(URL("https://meling-gradnja.hr/")),
      yearMade = 2021,
      description =
        "Website for a construction company made with Laravel. Uses self made sponsorware laravel packages."
    ),
    Reference(
      "Stay in Adriatic",
      CustomSoftware,
      Some(URL("https://stayinadriatic.com")),
      featured = true,
      yearMade = 2020,
      description =
        "Accommodation booking website made with Laravel and integrated with an external booking system Rentl.io."
    ),
    Reference(
      "Futurista",
      CustomSoftware,
      Some(URL("https://futurista.hr/")),
      yearMade = 2020,
      description =
        "Company website/blog made with Laravel. Design adapted from a Ghost blog template. Uses self made sponsorware blog laravel package."
    ),
    Reference(
      "Private transfers \"Karoca\"",
      CustomSoftware,
      Some(URL("https://taxiotokmurter.com/")),
      yearMade = 2019,
      description =
        "Company website for booking private transfers made with Laravel."
    ),
    Reference(
      "Butcher shop \"Milina\"",
      WebStandard,
      Some(URL("https://milina.hr/")),
      yearMade = 2019,
      description =
        "Simple one-page company website for a butcher shop made with Laravel."
    ),
    Reference(
      "Go Visit",
      WebStandard,
      Some(URL("https://govisit.hr/")),
      yearMade = 2018,
      description = "Company website for a software company made with Laravel."
    ),
    Reference(
      "Shipyard \"Ćiro\"",
      WebStandard,
      Some(URL("https://brodogradiliste-ciro.hr/")),
      yearMade = 2018,
      description = "Company website for shipyard Ćiro made with Grav CMS."
    ),
    Reference(
      "Damex",
      WebStandard,
      Some(URL("https://damex.hr/")),
      yearMade = 2018,
      description =
        "Simple company website for a bookkeeping business made with HTML, CSS and PHP."
    ),
    Reference(
      "Dragan Bašić",
      WebStandard,
      Some(URL("https://draganbasic.com/")),
      yearMade = 2018,
      description =
        "Personal website/portfolio for house construction made with Grav CMS."
    ),
    Reference(
      "VisitMurter",
      DirectoryListing,
      Some(URL("https://visitmurter.hr")),
      featured = true,
      yearMade = 2017,
      description =
        "Tourist information portal, API and android/ios mobile application made with Laravel and React-native."
    ),
    Reference(
      "Car service \"Antušina\"",
      WebStandard,
      Some(URL("https://antusina.hr/")),
      yearMade = 2017,
      description = "Car service company website made with Laravel."
    ),
    Reference(
      "Apartments \"Milina\"",
      WebStandard,
      Some(URL("https://apartmanimilina.com/")),
      yearMade = 2017,
      description = "Apartment booking website made with Laravel."
    ),
    Reference(
      "Adriatica Consult",
      WebStandard,
      Some(URL("http://adriaticaconsult.com/")),
      yearMade = 2016,
      description =
        "Business consulting company one-page website made with Laravel."
    ),
    Reference(
      "Studio \"Renata\"",
      WebStandard,
      Some(URL("http://studio-renata.hr/")),
      yearMade = 2016,
      description = "Hair salon company one-page website made with Laravel."
    ),
    Reference(
      "Real estate agency \"Treva\"",
      CustomSoftware,
      Some(URL("https://nekretnine-treva.com/")),
      yearMade = 2016,
      description = "Real estate agency website made with Laravel."
    ),
    Reference(
      "Apartments \"Kornat\"",
      CustomSoftware,
      Some(URL("https://apartmani-kornat.com/")),
      yearMade = 2015,
      description = "Apartment booking website made with Laravel."
    ),
    Reference(
      "Apartments \"Slanica\"",
      CustomSoftware,
      Some(URL("https://murter-apartments.com/")),
      yearMade = 2015,
      description = "Apartment booking website made with Laravel."
    ),
    Reference(
      "Villa \"Moj San\"",
      CustomSoftware,
      Some(URL("http://apartmani-zablace.com/")),
      yearMade = 2015,
      description = "Apartment booking website made with OctoberCMS."
    ),
    Reference(
      "G.I.M. Gase",
      BusinessApp,
      Some(URL("https://gimgase.hr")),
      featured = true,
      yearMade = 2015,
      description =
        "Web application made with Laravel and React.js for fire-extinguisher repair and business intelligence."
    ),
    Reference(
      "Dance studio \"Plesni Koraci\"",
      WebStandard,
      Some(URL("https://plesnikoraci.com/")),
      yearMade = 2014,
      description =
        "Company website for dance lessons and dance shows made with Laravel."
    ),
    Reference(
      "Hotel \"Murter\"",
      CustomSoftware,
      Some(URL("https://hotelmurter.com/")),
      yearMade = 2014,
      description =
        "Company website for a hotel in Murter made with Laravel. Integrated external service Rentlio for room bookings."
    ),
    Reference(
      "Real estate agency \"Adriatica\"",
      CustomSoftware,
      Some(URL("https://adriatica-nekretnine.hr/")),
      yearMade = 2014,
      description =
        "Real estate agency website made with Laravel. Integrated external service Crozilla for property marketing."
    ),
    Reference(
      "Tourist agency \"Murterin\"",
      CustomSoftware,
      Some(URL("https://murterin.com/")),
      yearMade = 2013,
      description =
        "Company website for a tourist agency made with Laravel. Consists of two Laravel applications: one API/CMS and one Website."
    ),
    Reference(
      "Real estate agency \"Duos\"",
      CustomSoftware,
      Some(URL("https://duos-croatia.com/")),
      yearMade = 2013,
      description =
        "Real estate agency website made with Laravel. Integrated external service iRealOne for property management."
    ),
    Reference(
      "Online store \"Daba\"",
      WebShop,
      Some(URL("https://daba.hr/")),
      yearMade = 2013,
      description =
        "Webshop for a woodworking company in Murter made with Laravel."
    ),
    Reference(
      "Virmanix",
      BusinessApp,
      Some(URL("https://virmanix.damex.hr/")),
      yearMade = 2013,
      description =
        "Business web application for printing virmans for a bookkeeping company made with Laravel."
    ),
    Reference(
      "Villa \"Renata\"",
      WebStandard,
      Some(URL("https://firstclassmurter.com/")),
      yearMade = 2012,
      description = "Apartment renting website made with Joomla."
    ),
    Reference(
      "Attorney \"Vjeran Paić\"",
      WebStandard,
      Some(URL("https://odvjetnik-vjeran-paic.com/")),
      yearMade = 2011,
      description = "Attorney at law website made with Joomla."
    )
  )
