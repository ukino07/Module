import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 5. 26..
 */
public class SortedSetTest {
    @Test
    public void 테스트() {
        Collection<Author> result = getAlphabeticalAuthors();
        System.out.println(result);
        assertEquals(1, 1);
    }

    public Collection<Author> getAlphabeticalAuthors() {
        Comparator<Author> sorter = new Comparator<Author>() {
            public int compare(Author author1, Author author2) {
                if (author1.getLastName().equals(author2.getLastName())) {
                    return author1.getFirstName().compareTo(author2.getFirstName());
                }
                return author2.getLastName().compareTo(author2.getLastName());
            }
        };

        SortedSet<Author> results = new TreeSet<Author>(sorter);

        for (Book each : getBook()) {
            results.add(each.getAuthor());
        }
        return results;
    }

    static class Author {
        private String firstName;
        private String lastName;

        public Author(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String toString() {
            return getFirstName() + " " + getLastName();
        }
    }

    static class Book {
        private String title;
        private Author author;

        public Book(String title, Author author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String toString() {
            return getTitle() + " (" + getAuthor() + ")";
        }
    }

    private List<Book> getBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("강이경의 일생", new Author("yikyung", "kang")));
        books.add(new Book("강선진의 일생", new Author("sunjin", "kang")));
        books.add(new Book("박정희의 일생", new Author("junghi", "park")));
        books.add(new Book("강재규의 일생", new Author("jaegyu", "kang")));
        books.add(new Book("김프로의 일생", new Author("pro", "kim")));
        return books;
    }
}
