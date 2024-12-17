package com.umaxcode.bottom_up_integration_test.repository;

import com.umaxcode.bottom_up_integration_test.domain.entity.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {

    List<NewsFeed> findNewsFeedByPostBy_Id(Long id);
}
