package com.blindbugs.chainsmokers.data.datasource

import com.blindbugs.chainsmokers.domain.model.Entry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset

class EntryMemoryDataSourceTest {
  @get:Rule val mockitoRule = MockitoJUnit.rule()

  lateinit var entryMemoryDataSource: EntryMemoryDataSource

  @Before
  fun setUp() {
    entryMemoryDataSource = EntryMemoryDataSource()
  }

  @Test
  fun givenAListOfEntries_ShouldReturnDailyTotals() {
    entryMemoryDataSource.save(Entry(LocalDateTime.of(2016, 1, 1, 10, 50).toEpochSecond(ZoneOffset.UTC)))
    entryMemoryDataSource.save(Entry(LocalDateTime.of(2016, 1, 1, 11, 50).toEpochSecond(ZoneOffset.UTC)))
    entryMemoryDataSource.save(Entry(LocalDateTime.of(2016, 1, 1, 12, 50).toEpochSecond(ZoneOffset.UTC)))
    entryMemoryDataSource.save(Entry(LocalDateTime.of(2016, 1, 2, 15, 50).toEpochSecond(ZoneOffset.UTC)))
    entryMemoryDataSource.save(Entry(LocalDateTime.of(2016, 1, 2, 15, 50).toEpochSecond(ZoneOffset.UTC)))

    val entriesByDay = entryMemoryDataSource.getEntriesByDay()

    assertEquals(2, entriesByDay.size)
    assertEquals(3, entriesByDay[LocalDate.of(2016, 1, 1)])
    assertEquals(2, entriesByDay[LocalDate.of(2016, 1, 2)])
  }

}