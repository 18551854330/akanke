package eu.kielczewski.akanke.common.repository;

import eu.kielczewski.akanke.common.domain.Document;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, String>,
		DocumentRepositoryCustom {

	@Query("SELECT d FROM Document d WHERE YEAR(d.datePublished) = ?1")
	Page<Document> findByYear(int year, Pageable pageable);

	@Query("SELECT d FROM Document d WHERE YEAR(d.datePublished) = ?1 AND MONTH(d.datePublished) = ?2")
	Page<Document> findByYearAndMonth(int year, int month, Pageable pageable);

	Page<Document> findByTags(String tag, Pageable pageable);

	Document getByFile(String file);

	@Modifying
	@Transactional
	@Query("delete from Document d where d.file = ?1")
	void deleteByFileStartingWith(String target);

	@Query("SELECT d FROM Document d ORDER BY (d.facebookStats.shareCount + d.facebookStats.commentCount) DESC")
	List<Document> getMostPopular(Pageable pageable);

}
