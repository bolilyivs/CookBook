package com.bolilyivs.cookbook.Repo;

import com.bolilyivs.cookbook.Entity.Recipe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    @Query( "SELECT r FROM Recipe r " +
            "JOIN r.tags rt " +
            "JOIN r.account acc " +
            "JOIN r.ingredients ing " +
            "WHERE r.title LIKE CONCAT('%',:title,'%') " +
            "AND rt.title IN (:tags) " +
            "AND ing.title IN (:ings) " +
            "AND acc.username LIKE CONCAT('%',:username,'%') " +
            "GROUP BY r.id " +
            "HAVING COUNT(DISTINCT rt.title)=:tagsSize " +
            "AND COUNT(DISTINCT ing.title)=:ingsSize")
    List<Recipe> searchAllTitleUsernameTagsIngredients(@Param("title")String title,
                                                       @Param("username") String username,
            @Param("tags") Set<String> tags, @Param("tagsSize") Long tagSize,
            @Param("ings") Set<String> ings, @Param("ingsSize") Long ingsSize,
                                                       Pageable page);

    @Query( "SELECT COUNT(r) FROM Recipe r WHERE r IN (" +
            "SELECT r FROM Recipe r " +
            "JOIN r.tags rt " +
            "JOIN r.account acc " +
            "JOIN r.ingredients ing " +
            "WHERE r.title LIKE CONCAT('%',:title,'%') " +
            "AND rt.title IN (:tags) " +
            "AND ing.title IN (:ings) " +
            "AND acc.username LIKE CONCAT('%',:username,'%') " +
            "GROUP BY r.id " +
            "HAVING COUNT(DISTINCT rt.title)=:tagsSize " +
            "AND COUNT(DISTINCT ing.title)=:ingsSize)")
    Long countTitleUsernameTagsIngredients(@Param("title")String title,
                                                       @Param("username") String username,
                                                       @Param("tags") Set<String> tags, @Param("tagsSize") Long tagSize,
                                                       @Param("ings") Set<String> ings, @Param("ingsSize") Long ingsSize);

    Optional<Recipe> findByTitle(String title);

}
