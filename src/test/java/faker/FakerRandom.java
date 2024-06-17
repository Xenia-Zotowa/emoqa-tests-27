package faker;

import com.github.javafaker.Faker;

public class FakerRandom {
    Faker faker = new Faker();

    public String day = String.valueOf(faker.number().numberBetween(1,28));
    public String month = faker.options().option("December","January","February", "March","April","May","June", "July", "August","September", "October","November");
    public String year = String.valueOf(faker.number().numberBetween(1980,2020));
    public String state = faker.options().option("NCR","Uttar Pradesh","Haryana", "Rajasthan");
    public String city = getRandomCity(state);
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String userPhone = faker.phoneNumber().subscriberNumber(10);
    public String gender = faker.options().option("Male", "Female", "Other");
    public String sabjects = faker.options().option("Maths","Chemistry","English", "Computer Science");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String photo = faker.options().option("25.jpg", "S.jpg");



        public String getRandomCity(String value){

        if (value.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (value.equals("Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (value.equals("Haryana")) {
            city = faker.options().option("Karnal", "Panipat");
        }
        if (value.equals("Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;

    }
}
