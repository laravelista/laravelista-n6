const defaultTheme = require('tailwindcss/defaultTheme')

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.scala", "./js/src/**/*.scala"],
  darkMode: 'class',

  theme: {
    extend: {
      fontFamily: {
        'sans': ['Sofia Sans', ...defaultTheme.fontFamily.sans],
        // 'serif': ['Nunito', ...defaultTheme.fontFamily.serif]
      },
      colors: {
        'border-color': 'rgb(255 255 255 / 35%)',
        'button-inactive': '#3c3a3a',
        'content-bg': 'rgb(146 151 179 / 13%)',
        'content-button-color': '#3a6df0',
        'content-button-hover-color': '#1e59f1',
        'content-text-color': '#ebecec',
        'content-title-color': '#3c3a3a',
        'dark-light-svg': '#ffce45',
        'dropdown-bg': '#f7f7f7',
        'inactive-color': 'rgb(113 119 144 / 78%)',
        'popup-bg': 'rgb(255 255 255)',
        'popup-box-shadow': 'rgba(0, 0, 0, 0.4)',
        'scrollbar-bg': 'rgb(255 253 253 / 57%)',
        'status-circle-color': '#396df0',
        'status-circle-green-color': '#3bf083',
        // 'theme-bg-color': 'rgb(255 255 255 / 31%)',
        'theme-color': '#3c3a3a',
        'overlay-app': 'rgba(36, 39, 59, 0.8)',
        'hover-menu-bg': 'rgba(255 255 255 / 35%)',

        'dark-border-color': 'rgba(113 119 144 / 25%)',
        'dark-button-inactive': 'rgb(249 250 251 / 55%)',
        'dark-content-bg': 'rgb(146 151 179 / 13%)',
        'dark-content-button-color': '#3a6df0',
        'dark-content-button-hover-color': '#1e59f1',
        'dark-content-text-color': '#ebecec',
        'dark-content-title-color': '#999ba5',
        'dark-dark-light-svg': '#ffce45',
        'dark-dropdown-bg': '#21242d',
        'dark-inactive-color': 'rgba(255,255,255, 0.5)', // rgb(113 119 144 / 80%)
        'dark-popup-bg': 'rgb(22 25 37)',
        'dark-popup-box-shadow': 'rgba(0, 0, 0, 0.4)',
        'dark-scrollbar-bg': 'rgb(1 2 3 / 40%)',
        'dark-status-circle-color': '#396df0',
        'dark-status-circle-green-color': '#3bf083',
        // 'dark-theme-bg-color': 'rgba(16 18 27 / 40%)',
        'dark-theme-color': '#f9fafb',
        'dark-overlay-app': 'rgba(36, 39, 59, 0.8)',
        'dark-hover-menu-bg': 'rgba(12 15 25 / 30%)',

        'product-web-shop-icon-color': '#3291b8',
        'product-booking-system-icon-color': '#ff8c51',
        'product-directory-listing-icon-color': '#fd31a2',
        'service-custom-software-icon-color': '#c1316d',
        'service-business-app-icon-color': '#c75deb',
        'service-web-standard-icon-color': '#a059a9'
      }
    },
  },
  plugins: [],
}
