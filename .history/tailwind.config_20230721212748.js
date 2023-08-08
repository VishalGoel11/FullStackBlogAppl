/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",


    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        'hero': "url('/ass/hero-pattern.svg')",
      }
    }\src\assets\heroBg.jpg
  },
  plugins: [],
}

