## How I did this exercise

As Kotlin is the language enhanced by Google to write Android applications, I chose this language for this exercise.

I first started to read the Gilded Rose Requirements Specification.
Then I read the code of the GildedRose.kt file.
I fixed the first test written in the test file.


The easiest way to refactor the code of this exercise was to create tests which would validate each requirement so none would be missed.
So I wrote a test for each specification.

Then this I started refactoring the GildedRose.kt file.

At last , I added 2 tests one for the new rose "Conjured" and one for the Sulfuras quality.
I changed the code after I wrote each test, so it could be valid.

"When" key word is the best option in Kotlin to check a value, so it was ideal to test if some conditions applied to a specific rose.
I chose to create a function for each type of rose for better readability.
Each function checks the specificities of the rose.


The 3 private functions have been added because they give more context to the code; 
for instance the quality maximum could change and not be 50 anymore, 
having a function testing the quality maximum enable the code responsible for the test of the rose's name agnostic about this value.

The name of the roses have been declared as variables because this is not a good practice to use hard coded value.
The specific roses could change at any moment. Now that variables exist it would be easiest to change names if needed or add a new one like the "Conjured" rose.

### How to compile the code
Use your terminal and do the following commands in this order
1. Copy the repository : git clone https://github.com/elisedesault/GildedRose-Refactoring-Kata.git

2. Access the file : cd GildedRose-Refactoring-Kata/Kotlin/

3. Run the code : ./gradlew build