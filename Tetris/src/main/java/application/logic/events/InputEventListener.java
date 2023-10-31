package application.logic.events;

import application.logic.DownData;
import application.logic.ViewData;

public interface InputEventListener {
	
	DownData onDownEvent(MoveEvent event);
	
	ViewData onLeftEvent();
	
	ViewData onRightEvent();
	
	ViewData onRotateEvent();

	void resetGame(MoveEvent event);
}
