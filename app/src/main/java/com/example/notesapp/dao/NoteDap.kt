package com.example.notesapp.dao

import androidx.room.*
import com.example.notesapp.entities.Notes

@Dao
interface NoteDap {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes() : List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}