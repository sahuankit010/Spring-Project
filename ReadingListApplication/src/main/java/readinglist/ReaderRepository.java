package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}
