package se.nackademin.engine;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SnakeSituationServiceImpl implements SnakeSituationService {

    @Override
    public SnakeSituation moveLeft(SnakeSituation situation) {
        situation.setStatus(SnackStatus.LIVE);
        List<Point> snake = situation.getSnake();
        Point head = snake.get(snake.size() - 1);
        Point food = situation.getFood();

        if (head.x - 1 == food.x && (head.y == food.y)) {
            snake.add(food);
            situation.setStatus(SnackStatus.EAT);
            situation.setSnake(snake);
            situation.setFood(AreaUtils.getRandomPoint(snake));
        } else {
            snake.remove(0);
            int newX = head.x - 1;
            if (newX < 0 || AreaUtils.isLocated(new Point(newX, head.y), snake)) {
                newX = head.x;
                snake.add(new Point(newX, head.y));
                situation.setSnake(snake);
                situation.setStatus(SnackStatus.DEAD);
                return situation;
            }
            snake.add(new Point(newX, head.y));
            situation.setSnake(snake);
        }
        return situation;
    }

    @Override
    public SnakeSituation moveRight(SnakeSituation situation) {
        situation.setStatus(SnackStatus.LIVE);
        List<Point> snake = situation.getSnake();
        Point head = snake.get(snake.size() - 1);
        Point food = situation.getFood();

        if (head.x + 1 == food.x && (head.y == food.y)) {
            snake.add(food);
            situation.setStatus(SnackStatus.EAT);
            situation.setSnake(snake);
            situation.setFood(AreaUtils.getRandomPoint(snake));
        } else {
            snake.remove(0);
            int newX = head.x + 1;
            if (newX > 15 || AreaUtils.isLocated(new Point(newX, head.y), snake)) {
                newX = head.x;
                snake.add(new Point(newX, head.y));
                situation.setSnake(snake);
                situation.setStatus(SnackStatus.DEAD);
                return situation;
            }
            snake.add(new Point(newX, head.y));
            situation.setSnake(snake);
        }
        return situation;
    }

    @Override
    public SnakeSituation moveUp(SnakeSituation situation) {
        situation.setStatus(SnackStatus.LIVE);
        List<Point> snake = situation.getSnake();
        Point head = snake.get(snake.size() - 1);
        Point food = situation.getFood();

        if (head.x == food.x && (head.y - 1 == food.y)) {
            snake.add(food);
            situation.setStatus(SnackStatus.EAT);
            situation.setSnake(snake);
            situation.setFood(AreaUtils.getRandomPoint(snake));
        } else {
            snake.remove(0);
            int newY = head.y - 1;
            if (newY < 0 || AreaUtils.isLocated(new Point(head.x, newY), snake)) {
                newY = head.y;
                snake.add(new Point(head.x, newY));
                situation.setSnake(snake);
                situation.setStatus(SnackStatus.DEAD);
                return situation;
            }
            snake.add(new Point(head.x, newY));
            situation.setSnake(snake);
        }
        return situation;
    }

    @Override
    public SnakeSituation moveDown(SnakeSituation situation) {
        situation.setStatus(SnackStatus.LIVE);
        List<Point> snake = situation.getSnake();
        Point head = snake.get(snake.size() - 1);
        Point food = situation.getFood();

        if (head.x == food.x && (head.y + 1 == food.y)) {
            snake.add(food);
            situation.setStatus(SnackStatus.EAT);
            situation.setSnake(snake);
            situation.setFood(AreaUtils.getRandomPoint(snake));
        } else {
            snake.remove(0);
            int newY = head.y+1;
            if (newY > 15 || AreaUtils.isLocated(new Point(head.x, newY), snake)) {
                newY = head.y;
                snake.add(new Point(head.x, newY));
                situation.setSnake(snake);
                situation.setStatus(SnackStatus.DEAD);
                return situation;
            }
            snake.add(new Point(head.x, newY));
            situation.setSnake(snake);
        }
        return situation;
    }
}
