package ru.sbrf.game2048;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Random;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class Game2048Test {

    @InjectMocks
    private Game2048 game;

    @Spy
    private GameHelper helper;

    @Spy
    private Random random;

    @Mock
    private SquareBoard<Integer> board;

    @Test
    public void testCanMove() {
        when(board.availableSpace()).thenReturn(asList(new Key(0,0),new Key(0,1)));
        assertTrue(game.canMove(), "canMove is incorrect");
    }

}
