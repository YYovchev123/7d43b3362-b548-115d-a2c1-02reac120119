Before you start the project you must have MySQL database installed. When you start it go to postman and at: localhost:8080/country/save,POST request, paste the array of countries and click Send. Then it should say "All countries are saved!".
After that you can search for countries by their country code. For example localhost:8080/country/BG, GET request. It should return the Object of Bulgaria.
