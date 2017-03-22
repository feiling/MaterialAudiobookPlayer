package de.ph1b.audiobook

import de.ph1b.audiobook.misc.NaturalOrderComparator
import java.io.File

/**
 * Represents a chapter in a book.
 *
 * @author Paul Woitaschek
 */
data class Chapter(val file: File, val name: String, val duration: Int, val fileLastModified: Long) : Comparable<Chapter> {

  init {
    check(name.isNotEmpty())
  }

  override fun compareTo(other: Chapter): Int {
    return NaturalOrderComparator.fileComparator.compare(file, other.file)
  }

  /**
   * Deletes the chapter file
   */
  fun delete() {
    file.delete()
  }
}