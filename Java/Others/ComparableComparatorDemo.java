import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//A class 'Movie' that implements Comparable 
class Movie implements Comparable<Movie> {
	
	private double rating;
	private String name;
	private int year;

	// Used to sort movies by year
	@Override
	public int compareTo(Movie m) {
		return this.year - m.year;
	}

	// Constructor
	public Movie(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}

	// Getter methods for accessing private data
	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return this.getRating() + " " + this.getName() + " " + this.getYear();
	}
}

public class ComparableComparatorDemo {

	public static void main(String[] args) {
		
        ArrayList<Movie> list = new ArrayList<Movie>();
		
        list.add(new Movie("Force Awakens", 8.3, 2015)); 
        list.add(new Movie("Star Wars", 8.7, 1977)); 
        list.add(new Movie("Empire Strikes Back", 8.8, 1980)); 
        list.add(new Movie("Return of the Jedi", 8.4, 1983)); 
  
        Collections.sort(list); 
  
        System.out.println("Movies after sorting year wise : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        Collections.sort(list, new Comparator<Movie>() {
			@Override
			public int compare(Movie m1, Movie m2) {
				if (m1.getRating() < m2.getRating()) 
					return -1; 
				else if (m1.getRating() > m2.getRating())   	
					return 1; 
				else return 0; 
			}
		}); 
        
        System.out.println("Movies after sorting rating wise : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        Collections.sort(list, Comparator.comparing(
                Movie::getRating, (m1, m2) -> {
                	if (m1 < m2) 		return -1; 
                	else if (m1 > m2) 	return 1; 
                	else 	return 0;
                }).reversed());
        
        System.out.println("Movies after sorting rating wise in reverse : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        Collections.sort(list, Comparator.comparingDouble(Movie::getRating)); 
        
        System.out.println("Movies after sorting rating wise (shortHand): ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
       
        Collections.sort(list, Comparator.comparing(Movie::getName));
        
        System.out.println("Movies after sorting name wise : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        Collections.sort(list, Comparator.comparing(Movie::getName).reversed());
        
        System.out.println("Movies after sorting name wise in reverse : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        Collections.sort(list, Comparator.<Movie> naturalOrder());
        
        System.out.println("Movies after sorting in Natural Order (Year Wise) : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        Collections.sort(list, Comparator.<Movie> reverseOrder());
        
        System.out.println("Movies after sorting in Reverse Natural Order (Year Wise) : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        
        System.out.println("Using Comparator.thenComparing ");
        
        list.add(new Movie("Force Awakens", 8.1, 2018)); 
        list.add(new Movie("Star Wars", 8.7, 1978)); 
        list.add(new Movie("Empire Strikes Back 2", 5.5, 1998)); 
        list.add(new Movie("Return of the Jedi", 9.0, 1999)); 
        
        Collections.sort(list, Comparator.comparing(Movie::getName)
                                         .thenComparingDouble(Movie::getRating)
                                         .thenComparingInt(Movie::getYear));
        
        System.out.println("Movies after sorting by Name, Rating, Year : ");
        System.out.println("---------------------------------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------");
	}
}
