package pl.bartek.shopkotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.history.RevisionRepository
import pl.bartek.shopkotlin.model.dao.Category

interface CategoryRepository: JpaRepository<Category, Long>, RevisionRepository<Category, Long, Long> {
}