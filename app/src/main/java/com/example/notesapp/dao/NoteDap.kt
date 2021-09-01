package com.example.notesapp.dao

import androidx.room.*
import com.example.notesapp.entities.Notes

@Dao
interface NoteDap {

    @get: Query("SELECT * FROM notes ORDER BY id DESC")
    val allNotes: List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(note:Notes)

    @Delete
    fun deleteNote(note: Notes)
}