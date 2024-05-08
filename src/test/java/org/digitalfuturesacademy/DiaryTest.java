package org.digitalfuturesacademy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DiaryTest {
  private Diary testDiary;
  private Entry testEntry;

  @BeforeEach
  public void testSetup() {
    testDiary = new Diary();
    testEntry = mock(Entry.class);
  }

  @Nested
  @DisplayName("Diary.addEntry() Test Suite")
  public class AddEntryTests {
    @Test
    @DisplayName("It should throw an exception when a user tries to add an entry to a locked diary.")
    public void testDoesNotAddEntryToLockedDiary() {
      RuntimeException thrownException = assertThrows(RuntimeException.class, () -> testDiary.addEntry(testEntry));

      assertEquals("Diary is locked", thrownException.getMessage());
    }
  }
}
