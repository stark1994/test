import org.junit.Before;
import org.sefMusicMain.Artist;
import org.junit.Test;

//import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddArtistTest {





    @Test
    public void test_Add_Artist_ValidData() {
        // Call the addArtist method with valid data
        Artist artist;
        ArrayList<String> occupations = new ArrayList<>();
        occupations.add("Singer");
        occupations.add("Songwriter");

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Pop");
        genres.add("R&B");

        ArrayList<String> awards = new ArrayList<>();
        awards.add("2020, Grammy");
        awards.add("1990, MTV Music");

        artist = new Artist(
                "569MMRPR_%",
                "Jhon Smith",
                "LosAngeles|CA|USA",
                "15-07-1990",
                "Chart-topping sensation with a voice that lights up the world, leaving a trail of glittering hits in her wake.",
                occupations,
                genres,
                awards);
        boolean result = artist.addArtist();

        // Assert that the addArtist method returns true for valid data
        assertTrue(result);
    }

    @Test
    public void testAddArtistInvalidData() {
        // Set invalid data for testing (e.g., empty ID and Name)
        ArrayList<String> occupations = new ArrayList<>();
        occupations.add("Singer");
        occupations.add("Songwriter");

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Pop");
        genres.add("R&B");

        ArrayList<String> awards = new ArrayList<>();
        awards.add("2020, Grammy");
        awards.add("1990, MTV Music");

        Artist artist = new Artist(
                "569M",
                "Rayan Britten",
                "LosAngeles|CA|USA",
                "15-07-1990",
                "Chart-topping sensation with a voice that lights up the world, leaving a trail of glittering hits in her wake.",
                occupations,
                genres,
                awards);

        // Call the addArtist method with invalid data
        boolean result = artist.addArtist();

        // Assert that the addArtist method returns false for invalid data
        assertFalse(result);
    }

    @Test
    public void testUpdateValidArtis() {
        // Set invalid data for testing (e.g., empty ID and Name)
        Artist artist;
        ArrayList<String> occupations = new ArrayList<>();
        occupations.add("Singer");
        occupations.add("Songwriter");

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Pop");
        genres.add("R&B");

        ArrayList<String> awards = new ArrayList<>();
        awards.add("2020, Grammy");
        awards.add("1990, MTV Music");

        artist = new Artist(
                "569MMRPR_%",
                "Jhon Paul Smith",
                "LosAngeles|CA|USA",
                "15-07-1990",
                "Chart-topping sensation with a voice that lights up the world, leaving a trail of glittering hits in her wake.",
                occupations,
                genres,
                awards);
        boolean result = artist.updateArtist();

        // Assert that the addArtist method returns true for valid data
        assertTrue(result);
    }
    @Test
    public void testAddArtistInvalidID() {
        // Set invalid data for testing (e.g., empty ID and Name)
        Artist artist;
        ArrayList<String> occupations = new ArrayList<>();
        occupations.add("Singer");
        occupations.add("Songwriter");

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Pop");
        genres.add("R&B");

        ArrayList<String> awards = new ArrayList<>();
        awards.add("2020, Grammy");
        awards.add("1990, MTV Music");

        artist = new Artist(
                "569MRPR_%",
                "Jhon Smith",
                "LosAngeles|CA|USA",
                "15-07-1990",
                "Chart-topping sensation with a voice that lights up the world, leaving a trail of glittering hits in her wake.",
                occupations,
                genres,
                awards);
        boolean result = artist.addArtist();

        // Assert that the addArtist method returns true for valid data
        assertFalse(result);
    }
    @Test
    public void testAddArtistInvalidOccupation() {
        // Set invalid data for testing (e.g., empty ID and Name)
        Artist artist;
        ArrayList<String> occupations = new ArrayList<>();

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Pop");
        genres.add("R&B");

        ArrayList<String> awards = new ArrayList<>();
        awards.add("2020, Grammy");
        awards.add("1990, MTV Music");

        artist = new Artist(
                "569MMRPR_%",
                "Jhon Smith",
                "LosAngeles|CA|USA",
                "15-07-1990",
                "Chart-topping sensation with a voice that lights up the world, leaving a trail of glittering hits in her wake.",
                occupations,
                genres,
                awards);
        boolean result = artist.addArtist();

        // Assert that the addArtist method returns true for valid data
        assertFalse(result);
    }

    @Test
    public void testAddArtistInvalidBio() {
        // Set invalid data for testing (e.g., empty ID and Name)
        Artist artist;
        ArrayList<String> occupations = new ArrayList<>();

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Pop");
        genres.add("R&B");

        ArrayList<String> awards = new ArrayList<>();
        awards.add("2020, Grammy");
        awards.add("1990, MTV Music");

        artist = new Artist(
                "569MMRPR_%",
                "Jhon Smith",
                "LosAngeles|CA|USA",
                "15-07-1990",
                "trail of glittering hits in her wake.",
                occupations,
                genres,
                awards);
        boolean result = artist.addArtist();

        // Assert that the addArtist method returns true for valid data
        assertFalse(result);
    }
}
