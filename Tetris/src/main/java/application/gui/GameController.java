package application.gui;

import application.logic.ClearRow;
import application.logic.DownData;
import application.logic.SimpleBoard;
import application.logic.ViewData;
import application.logic.events.EventSource;
import application.logic.events.InputEventListener;
import application.logic.events.MoveEvent;

public class GameController implements InputEventListener{
	
	private SimpleBoard board = new SimpleBoard(25, 10);
	
	private final GuiController viewController;
	
	public GameController(GuiController c) {
		this.viewController = c;
		this.viewController.setEventLister(this);
		board.createNewBrick();
		this.viewController.initGameView(board.getBoardMatrix(), board.getViewData());
		this.viewController.bindScore(board.getScore().scoreProperty());
	}

	@SuppressWarnings("exports")
	@Override
	public DownData onDownEvent(MoveEvent event) {
		boolean canMove = board.moveBrickDown();
		ClearRow clearRow = null;
		if(!canMove) {
			board.mergeBrickToBackground();
			clearRow = board.clearRows();
			if(clearRow.getLinesRemoved() > 0) {
				board.getScore().add(clearRow.getScoreBonus());
			}
			
			if(board.createNewBrick()) {
				viewController.gameOver();
			}
			
		}else {
			if(event.getEventSource() == EventSource.USER) {
				board.getScore().add(1);
			}
		}
		
		viewController.refreshGameBackground(board.getBoardMatrix());
		
		return new DownData(clearRow, board.getViewData());
	}

	@SuppressWarnings("exports")
	@Override
	public ViewData onLeftEvent() {
		board.moveBrickLeft();
		
		return board.getViewData();
	}

	@SuppressWarnings("exports")
	@Override
	public ViewData onRightEvent() {
		board.moveBrickRight();
		
		return board.getViewData();
	}

	@SuppressWarnings("exports")
	@Override
	public ViewData onRotateEvent() {
		board.rotateBrickLeft();
		
		return board.getViewData();
	}
	
	@Override
	public void resetGame(MoveEvent event) {
		
		ClearRow clearRow = board.clearAllRows();
		board.getScore().setToZero();
		
		viewController.refreshGameBackground(board.getBoardMatrix());
		
        board = new SimpleBoard(25, 10);
        board.createNewBrick();
        viewController.initGameView(board.getBoardMatrix(), board.getViewData());
        viewController.bindScore(board.getScore().scoreProperty());
    }
}