package tests;

public class TestData {
    protected String firstName = getRandomFirstName,
            lastName = getRandomLastName,
            address = getRandomAddress,
            email = getRandomEmail,
            phoneNumber = getRandomPhone,
            gender = getRandomGender,
            birthDaySent = getRandomBirthDay,
            birthMonthSent = getRandomBirthMonth,
            birthYearSent = getRandomBirthYear,
            subjectName = getRandomSubject,
            hobbyName = getRandomHobby(),
            stateName = getRandomState(),
            cityName = getRandomCity(stateName),
            filePath = getFilePath(),
            fileName = getFileName();
}
