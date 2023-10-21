package org.sefMusicMain;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Artist {

    private static final String filePath = "src/main/resources/artistDetails.txt";
    private String ID;
    private String Name;
    private String Address;
    private String Birthdate;
    private String Bio;
    private ArrayList<String> Occupations;
    private ArrayList<String> Genres;
    private ArrayList<String> Awards;

    public Artist(String id, String name, String address, String birthdate, String bio, ArrayList<String> occupations, ArrayList<String> genres, ArrayList<String> awards) {
        ID = id;
        Name = name;
        Address = address;
        Birthdate = birthdate;
        Bio = bio;
        Occupations = occupations;
        Genres = genres;
        Awards = awards;
    }

    public boolean addArtist() {
//        System.out.println("testing");
        if (ID != null && !ID.isEmpty() && Name != null && !Name.isEmpty()) {
            if (isValidArtistInfo()) {

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write("ID: " + ID + "\n");
                    writer.write("Name: " + Name + "\n");
                    writer.write("Address: " + Address + "\n");
                    writer.write("Birthdate: " + Birthdate + "\n");
                    writer.write("Bio: " + Bio + "\n");

                    writer.write("Occupations:\n");
                    for (String occupation : Occupations) {
                        writer.write(occupation + "\n");
                    }

                    writer.write("Genres:\n");
                    for (String genre : Genres) {
                        writer.write(genre + "\n");
                    }

                    writer.write("Awards:\n");
                    for (String award : Awards) {
                        writer.write(award + "\n");
                    }

                    writer.write("\n"); // Separation between artists
                    return true;
                } catch (IOException e) {
                    // Handle the exception (e.g., log or throw it).
                    e.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }

    private boolean isValidArtistInfo() {
        // Condition 1: Artist ID should be exactly 10 characters long with the specified format.
        if (!Pattern.matches("[5-9]{3}[A-Z]{5}[^a-zA-Z0-9]{2}", this.ID)) {
            return false;
        }

        // Condition 2: Birth date format should be DD-MM-YYYY.
        if (!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$", Birthdate)) {
            return false;
        }

        // Condition 3: Address format should be CityStateCountry.
        if (!Pattern.matches("^[A-Za-z]+\\|[A-Za-z]+\\|[A-Za-z]+$", Address)) {
            return false;
        }

        // Condition 4: Bio should be between 10 to 30 words.
        int wordCount = Bio.split("\\s+").length;
        if (wordCount < 10 || wordCount > 30) {
            return false;
        }

        // Condition 5: An artist should have at least one occupation or a maximum of five occupations.
        if (Occupations.isEmpty() || Occupations.size() > 5) {
            return false;
        }

        // Condition 6: Each award should follow the specified format.
        for (String award : Awards) {
            if (!Pattern.matches("^\\d{4}, [A-Za-z ]{4,10}$", award)) {
                return false;
            }
        }

        // Condition 7: An artist should be active in at least two music genres and a maximum of five genres.
        if (Genres.size() < 2 || Genres.size() > 5 || (Genres.contains("pop") && Genres.contains("rock"))) {
            System.out.println("Not in format generes");
            return false;
        }

        return true;
    }


    public boolean updateArtist() {
        if (!isValidArtistInfo()) {

            try {

                File inputFile = new File(filePath);
//                File updatedFile = new File("src/main/resources/updatedDetails.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));

                String line;

                //array to store the different words
                String[] words;//

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);

                }
                addArtist();
                reader.close();
                return true;
            } catch (IOException e) {
                System.err.println("Error updating artist information: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return true;
    }

}
