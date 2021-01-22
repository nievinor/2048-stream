package ru.sbrf.game2048;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class SquareBoardTest {

    private Board<Key, Integer> board;

    @BeforeEach
    public void initBoard()
    {
        board = new SquareBoard<>(2);
        board.fillBoard(asList(1,2,3,null));
    }

    @Test
    public void testFillBoard() {
        assertAll(
                () -> assertThrows(RuntimeException.class,()->board.fillBoard(asList(1,2,3)),
                        "fillBoard not trows exception"),
                () -> {
                    board.fillBoard(asList(5,6,7,8));
                    assertTrue(board.availableSpace().isEmpty(), "fillBoard is incorrect");
                }

        );
    }

    @Test
    public void testAvailableSpace() {
        assertEquals(board.availableSpace().get(0),board.getKey(1,1),"availableSpace is incorrect");
    }

    @Test
    public void testGetKey() {
        assertAll(
                () -> assertEquals(board.getKey(0,0),board.getKey(0, 0),"Keys incorrect value"),
                () -> assertNull(board.getKey(2, 2), "Not found key is null")
        );
    }

    @Test
    public void testGetValue() {
        assertNull(board.getValue(board.getKey(1, 1)), "getValue is incorrect");
    }

    @Test
    public void testHasValue() {
        assertAll(
                () -> assertTrue(board.hasValue(null), "hasValue is incorrect"),
                () -> assertTrue(board.hasValue(3), "hasValue is incorrect")
        );
    }

    @Test
    public void testGetColumn() {
        assertEquals(board.getColumn(0), asList(board.getKey(0,0), board.getKey(1,0)),
                "getColumn is incorrect");
    }

    @Test
    public void testGetRow() {
        assertEquals(board.getRow(0), asList(board.getKey(0,0), board.getKey(0,1)),
                "getRow is incorrect");
    }

    @Test
    public void testGetValues() {
        assertEquals(board.getValues(board.getColumn(0)), asList(1, 3), "getValues is incorrect");
    }

}
