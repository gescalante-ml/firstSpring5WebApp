package gurur.springframework.spring5webapp.bootstrap;

import gurur.springframework.spring5webapp.model.Author;
import gurur.springframework.spring5webapp.model.Book;
import gurur.springframework.spring5webapp.model.Publisher;
import gurur.springframework.spring5webapp.repositories.AuthorRepository;
import gurur.springframework.spring5webapp.repositories.BookRepository;
import gurur.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        Publisher pub1 = new Publisher("Harper Collins","Avenue 4");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub1);

        publisherRepository.save(pub1);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book( "J2EE Development without EJB",  "23344");
        Publisher pub2 = new Publisher("Worx","Avenue 3");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub2);

        publisherRepository.save(pub2);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        //Rod






    }
}
