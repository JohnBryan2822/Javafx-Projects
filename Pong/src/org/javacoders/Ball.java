package org.javacoders;

public class Ball {
	public Rect rect;
	public Rect leftPaddle, rightPaddle;
	public Text leftScoreText, rightScoreText;

	// velocity x, y
	private double vy = 10.0;
	private double vx = -200.0;
	
	public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle, Text leftScoreText, Text rightScoreText) {
		this.rect = rect;
		this.leftPaddle = leftPaddle;
		this.rightPaddle = rightPaddle;
		this.leftScoreText = leftScoreText;
		this.rightScoreText = rightScoreText;
	}
	
	public double calculateNewVelocityAngle(Rect paddle) {
		double relativeIntersectY = (paddle.y + (paddle.height / 2.0)) - (this.rect.y + (this.rect.height / 2.0));
		double normalIntersectY = relativeIntersectY / (paddle.height / 2.0);
		double theta = normalIntersectY * Constants.MAX_ANGLE;
		
		return Math.toRadians(theta);
	}
	
	public void update(double dt) {
		
		if(vx < 0.0) {
			if(this.rect.x <= this.leftPaddle.x + this.leftPaddle.width && this.rect.x + this.rect.width >= this.leftPaddle.x &&
					this.rect.y >= this.leftPaddle.y && this.rect.y <= this.leftPaddle.y + this.leftPaddle.height) {
				
				double theta = calculateNewVelocityAngle(leftPaddle);
				double newVx = Math.abs((Math.cos(theta)) * Constants.PADDLE_SPEED);
				double newVy = -(Math.sin(theta)) * Constants.PADDLE_SPEED;
				
				double oldSign = Math.signum(vx);
				this.vx = newVx * (-1.0 * oldSign);
				this.vy = newVy;
				
			}
		} else if(vx > 0) {
			if(this.rect.x + this.rect.width >= this.rightPaddle.x && this.rect.x <= this.rightPaddle.x + this.rightPaddle.width &&
					this.rect.y >= this.rightPaddle.y && this.rect.y <= this.rightPaddle.y + this.rightPaddle.height) {
				
				double theta = calculateNewVelocityAngle(rightPaddle);
				double newVx = Math.abs((Math.cos(theta)) * Constants.PADDLE_SPEED);
				double newVy = -(Math.sin(theta)) * Constants.PADDLE_SPEED;
				
				double oldSign = Math.signum(vx);
				this.vx = newVx * (-1.0 * oldSign);
				this.vy = newVy;
				
			}
		}
		
		if(vy > 0.0) {
			if(this.rect.y + this.rect.height > Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
				this.vy *= -1.0;
			}
		} else if(vy < 0.0) {
			if(this.rect.y < Constants.TOOLBAR_HEIGHT) {
				this.vy *= -1.0;
			}
		}
		
		this.rect.x += vx * dt;
		this.rect.y += vy * dt;
		
		if(this.rect.x + this.rect.width < leftPaddle.x) {
			int rightScore = Integer.parseInt(rightScoreText.text);
			rightScore++;
			rightScoreText.text = "" + rightScore;
			this.rect.x = Constants.SCREEN_WIDTH / 2.0;
			this.rect.y = Constants.SCREEN_HEIGHT / 2.0;
			this.vy = 10.0;
			this.vx = -150;
			if(rightScore >= Constants.WIN_SCORE) {
				Main.changeState(2);
			}
		} else if(this.rect.x > rightPaddle.x + rightPaddle.width) {
			int leftScore = Integer.parseInt(leftScoreText.text);
			leftScore++;
			leftScoreText.text = "" + leftScore;
			this.rect.x = Constants.SCREEN_WIDTH / 2.0;
			this.rect.y = Constants.SCREEN_HEIGHT / 2.0;
			this.vy = 10.0;
			this.vx = 150;
			if(leftScore >= Constants.WIN_SCORE) {
				Main.changeState(2);
			}
		}
	}

}













