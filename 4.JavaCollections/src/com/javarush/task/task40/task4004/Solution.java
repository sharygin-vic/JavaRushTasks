package com.javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
//    public static void main(String[] args) {
//        List<Point> polygon = new ArrayList<>();
//        polygon.add(new Point(0, 0));
//        polygon.add(new Point(0, 10));
//        polygon.add(new Point(10, 10));
//        polygon.add(new Point(10, 0));
//
//        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
//        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
//    }

    //test_1
//    public static void main(String[] args) {
//        System.out.println(isPointInPolygon(null, null));
//    }

    //test_2
//    public static void main(String[] args) {
//        List<Point> polygon = new ArrayList<>();
//        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
//    }

    //test_3
//    public static void main(String[] args) {
//        List<Point> polygon = new ArrayList<>();
//        polygon.add(new Point(0, 0));
//        System.out.println(isPointInPolygon(new Point(0, 0), polygon));
//    }

    //test_4
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        System.out.println();
        polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 2));
        polygon.add(new Point(1, 3));
        polygon.add(new Point(2, 2));
        polygon.add(new Point(4, 2));
        polygon.add(new Point(7, 5));
        polygon.add(new Point(9, 3));
        polygon.add(new Point(9, 0));
        System.out.println("1 : ожидается false - получено " + isPointInPolygon(new Point(-1, 0), polygon));
        System.out.println("2 : ожидается true  - получено " + isPointInPolygon(new Point(0, 0), polygon));
        System.out.println("3 : ожидается true  - получено " + isPointInPolygon(new Point(1, 0), polygon));
        System.out.println("4 : ожидается true  - получено " + isPointInPolygon(new Point(2, 1), polygon));
        System.out.println("5 : ожидается true  - получено " + isPointInPolygon(new Point(3, 2), polygon));
        System.out.println("6 : ожидается true  - получено " + isPointInPolygon(new Point(1, 3), polygon));
        System.out.println("7 : ожидается true  - получено " + isPointInPolygon(new Point(5, 3), polygon));
        System.out.println("8 : ожидается false - получено " + isPointInPolygon(new Point(3, 3), polygon));
        System.out.println("9 : ожидается false - получено " + isPointInPolygon(new Point(3, 4), polygon));
        System.out.println("10 : ожидается true - получено " + isPointInPolygon(new Point(6, 4), polygon));
        System.out.println("11 : ожидается true - получено " + isPointInPolygon(new Point(7, 4), polygon));
        System.out.println("12 : ожидается true - получено " + isPointInPolygon(new Point(7, 5), polygon));
        System.out.println("13 : ожидается false - получено " + isPointInPolygon(new Point(9, 4), polygon));
        System.out.println("14 : ожидается true  - получено " + isPointInPolygon(new Point(9, 3), polygon));
        System.out.println("15 : ожидается true  - получено " + isPointInPolygon(new Point(9, 1), polygon));
        System.out.println("16 : ожидается false - получено " + isPointInPolygon(new Point(9, 5), polygon));
        System.out.println("17 : ожидается false - получено " + isPointInPolygon(new Point(10, 0), polygon));
        System.out.println("18 : ожидается false - получено " + isPointInPolygon(new Point(10, 2), polygon));
        System.out.println("19 : ожидается true  - получено " + isPointInPolygon(new Point(8, 3), polygon));
        System.out.println("20 : ожидается true  - получено " + isPointInPolygon(new Point(7, 2), polygon));
        System.out.println("21 : ожидается true  - получено " + isPointInPolygon(new Point(1, 2), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        if (point == null || polygon == null || polygon.size() < 1) {
            return false;
        }

        //return isPointInPolygonByAgeDirection(point, polygon);
        // Валидацию JavaRush не проходит - алгоритм принципиально не годится для невыпуклых фигур
        //test_4 result:
        /*
        1 : ожидается false - получено false
        2 : ожидается true  - получено true
        3 : ожидается true  - получено true
        4 : ожидается true  - получено false
        5 : ожидается true  - получено false
        6 : ожидается true  - получено true
        7 : ожидается true  - получено false
        8 : ожидается false - получено false
        9 : ожидается false - получено false
        10 : ожидается true - получено false
        11 : ожидается true - получено false
        12 : ожидается true - получено false
        13 : ожидается false - получено false
        14 : ожидается true  - получено false
        15 : ожидается true  - получено false
        16 : ожидается false - получено false
        17 : ожидается false - получено false
        18 : ожидается false - получено false
        19 : ожидается true  - получено false
        20 : ожидается true  - получено false
        21 : ожидается true  - получено false
        */

        //---------------------------------------------------------

        return isPointInPolygonByLeftRayCrossing(point, polygon);
        // Валидацию JavaRush не проходит - хотя по результатам теста ошибок нет
        // Похоже, в этой задаче ошибка валидатора.
        //test_4 result:
        /*
        1 : ожидается false - получено false
        2 : ожидается true  - получено true
        3 : ожидается true  - получено true
        4 : ожидается true  - получено true
        5 : ожидается true  - получено true
        6 : ожидается true  - получено true
        7 : ожидается true  - получено true
        8 : ожидается false - получено false
        9 : ожидается false - получено false
        10 : ожидается true - получено true
        11 : ожидается true - получено true
        12 : ожидается true - получено true
        13 : ожидается false - получено false
        14 : ожидается true  - получено true
        15 : ожидается true  - получено true
        16 : ожидается false - получено false
        17 : ожидается false - получено false
        18 : ожидается false - получено false
        19 : ожидается true  - получено true
        20 : ожидается true  - получено true
        21 : ожидается true  - получено true
        */

        //--------------------------------------------

        //return isPointInPolygon3(point, polygon);
        // Валидацию JavaRush проходит - хотя по результатам теста есть 8 ошибок.
        // Похоже, в этой задаче ошибка валидатора.
        //test_4 result:
        /*
        1 : ожидается false - получено false
        2 : ожидается true  - получено false
        3 : ожидается true  - получено true
        4 : ожидается true  - получено true
        5 : ожидается true  - получено true
        6 : ожидается true  - получено false
        7 : ожидается true  - получено false
        8 : ожидается false - получено false
        9 : ожидается false - получено false
        10 : ожидается true - получено false
        11 : ожидается true - получено true
        12 : ожидается true - получено false
        13 : ожидается false - получено false
        14 : ожидается true  - получено true
        15 : ожидается true  - получено true
        16 : ожидается false - получено false
        17 : ожидается false - получено true
        18 : ожидается false - получено true
        19 : ожидается true  - получено true
        20 : ожидается true  - получено false
        21 : ожидается true  - получено true
        */
    }


    //==============================================================

    // Валидатор JavaRush не принял - причина непонятна.
    // Метод считает количество пересечений с контуром полилинии горизонтального луча из тестовой точки слева.
    // Корректно обрабатывает прохождение луча через горизонтальные отрезки полилинии и ее вершины.
    // Корректно работает с самопересекающимся контуром и петлями, полученными при совпадении координат вершин.
    private static boolean isPointInPolygonByLeftRayCrossing(Point point, List<Point> polygon) {
        Point vertex = polygon.get(0);
        int xMin = vertex.x;
        int xMax = vertex.x;
        int yMin = vertex.y;
        int yMax = vertex.y;
        for (int i = 1; i <= polygon.size(); i++) {
            Point vertexPrev;
            if (i == polygon.size()) {
                vertex = polygon.get(0);
                vertexPrev = polygon.get(polygon.size() - 1);
            }
            else {
                vertex = polygon.get(i);
                vertexPrev = polygon.get(i - 1);
            }

            int xMinEdge = vertex.x;
            int xMaxEdge = vertex.x;
            int yMinEdge = vertex.y;
            int yMaxEdge = vertex.y;
            if (vertexPrev.x < xMinEdge) xMinEdge = vertexPrev.x;
            else if (vertexPrev.x > xMaxEdge) xMaxEdge = vertexPrev.x;
            if (vertexPrev.y < yMinEdge) yMinEdge = vertexPrev.y;
            else if (vertexPrev.y > yMaxEdge) yMaxEdge = vertexPrev.y;
            if ( ((vertex.x - point.x)*(vertexPrev.y - point.y) - (vertex.y - point.y)*(vertexPrev.x - point.x) == 0) &&
                    point.x >= xMinEdge && point.x <= xMaxEdge  &&  point.y >= yMinEdge && point.y <= yMaxEdge ) {
                return true;    // point on the edge
            }

            if (vertex.x < xMin) xMin = vertex.x;
            else if (vertex.x > xMax) xMax = vertex.x;
            if (vertex.y < yMin) yMin = vertex.y;
            else if (vertex.y > yMax) yMax = vertex.y;
        }
        if (point.x < xMin || point.x > xMax || point.y < yMin || point.y > yMax)
            return false;       // точка вне габаритного контейнера полилинии

        ArrayList<CrossType> crosses = new ArrayList<>();
        for (int i = 1; i < polygon.size(); i++) {
            Point vertexPrev;
            if (i == polygon.size()) {
                vertex = polygon.get(0);
                vertexPrev = polygon.get(polygon.size() - 1);
            }
            else {
                vertex = polygon.get(i);
                vertexPrev = polygon.get(i - 1);
            }

            if (vertex.y == vertexPrev.y && vertex.y == point.y) {
                continue;  // горизонтальное ребро полилинии совпадающее с секущим лучом
            }
            if (vertex.y == point.y && vertex.x <= point.x) {
                if (vertex.y < vertexPrev.y) {
                    crosses.add(CrossType.VERTEX_BOTTOM);
                }
                else {
                    crosses.add(CrossType.VERTEX_TOP);
                }
            }
            else if (vertexPrev.y == point.y && vertexPrev.x <= point.x) {
                if (vertexPrev.y < vertex.y) {
                    crosses.add(CrossType.VERTEX_BOTTOM);
                }
                else {
                    crosses.add(CrossType.VERTEX_TOP);
                }
            }
            else if (vertex.y < point.y && vertexPrev.y > point.y ||
                     vertexPrev.y < point.y && vertex.y > point.y) {
                if (vertex.x > point.x && vertexPrev.x > point.x) {
                    continue;    // ребро правее точки и 100% не пересекается левонаправленным лучом
                }
                // есть пересечение - ищем его координату X:
                // Решаем пропорцию:
                //  (crossingX - vertex.x) / (vertexPrev.x - vertex.x) = (crossingY - vertex.y) / (vertexPrev.y - vertex.y), где crossingY == point.y
                double crossingX = (point.y - vertex.y) / ((double)(vertexPrev.y - vertex.y)) * (vertexPrev.x - vertex.x) + vertex.x;
                if (crossingX <= point.x) {
                    crosses.add(CrossType.EDGE);
                }
            }
        }

        // Анализ списка пересечений:

        //System.out.print(crosses.size() + " : ");

        if (crosses.size() == 0) {
            return false;
        }
        int crossingCount = 1;
        for (int i = 1; i < crosses.size(); i++) {
            CrossType crossing = crosses.get(i);
            CrossType crossingPrev = crosses.get(i-1);
            if ( (crossing == CrossType.VERTEX_BOTTOM || crossing == CrossType.VERTEX_TOP) && crossing == crossingPrev  ||
                    crossing == CrossType.EDGE  ) {
                crossingCount++;  // пересечение в вершине с двумя восходящими ребрами или в вершине с двумя нисходящими ребрами или с серединой ребра
            }
        }

        //System.out.print(crossingCount + " : ");

        return (crossingCount > 0) && ((crossingCount & 1) == 1);  // true if нечетное
    }

    enum CrossType {
        EDGE,
        VERTEX_TOP,
        VERTEX_BOTTOM;
    }


    //==============================================================

    // Валидатор JavaRush не принял - вероятно, тестировал невыпуклый многоугольник.
    // Метод определяет совпадение направления вращения векторов (точка -> вершина полилинии) для всех вершин.
    // Для точки внутри фигуры все направления одинаковы.
    // Алгоритм только для выплых фигур.
    private static boolean isPointInPolygonByAgeDirection(Point point, List<Point> polygon) {
//        System.out.println("---------------------------");

        int signLast = 1;

        Point vertex = polygon.get(0);
        Point vertexPrev = polygon.get(polygon.size() - 1);
        int vectorZLast = (vertex.x - point.x)*(vertexPrev.y - point.y) - (vertex.y - point.y)*(vertexPrev.x - point.x);
        if (vectorZLast == 0) {
            int xMinEdge = vertex.x;
            int xMaxEdge = vertex.x;
            int yMinEdge = vertex.y;
            int yMaxEdge = vertex.y;
            if (vertexPrev.x < xMinEdge) xMinEdge = vertexPrev.x;
            else if (vertexPrev.x > xMaxEdge) xMaxEdge = vertexPrev.x;
            if (vertexPrev.y < yMinEdge) yMinEdge = vertexPrev.y;
            else if (vertexPrev.y > yMaxEdge) yMaxEdge = vertexPrev.y;
            if ( point.x >= xMinEdge && point.x <= xMaxEdge  &&  point.y >= yMinEdge && point.y <= yMaxEdge ) {
                return true;    // point on the edge
            }
        }
        else {
            signLast = vectorZLast / Math.abs(vectorZLast);
//            System.out.println("signLast = " + signLast);
        }

        for (int i = 1; i < polygon.size(); i++) {
            vertex = polygon.get(i);
            vertexPrev = polygon.get(i-1);
            int vectorZCur = (vertex.x - point.x)*(vertexPrev.y - point.y) - (vertex.y - point.y)*(vertexPrev.x - point.x);

            if (vectorZCur == 0) {
                int xMinEdge = vertex.x;
                int xMaxEdge = vertex.x;
                int yMinEdge = vertex.y;
                int yMaxEdge = vertex.y;
                if (vertexPrev.x < xMinEdge) xMinEdge = vertexPrev.x;
                else if (vertexPrev.x > xMaxEdge) xMaxEdge = vertexPrev.x;
                if (vertexPrev.y < yMinEdge) yMinEdge = vertexPrev.y;
                else if (vertexPrev.y > yMaxEdge) yMaxEdge = vertexPrev.y;
                if ( point.x >= xMinEdge && point.x <= xMaxEdge  &&  point.y >= yMinEdge && point.y <= yMaxEdge ) {
                    return true;    // point on the edge
                }
            }
            else {
                int signCur = vectorZCur / Math.abs(vectorZCur);
//                System.out.println("signCur = " + signCur);
                if (signLast != signCur) {
                    return false;
                }
            }
        }

        return true;
    }


    //==============================================================

    // Алгоритм с ошибками, но проходит валидацию JavaRush:
    private static boolean isPointInPolygon3(Point point, List<Point> polygon) {
        boolean res = false;
        int j=polygon.size()-1;

        for (int i = 0; i < polygon.size(); i++) {
            if ((((polygon.get(i).y < point.y) && (point.y < polygon.get(j).y)) || ((polygon.get(j).y <= point.y) && (point.y < polygon.get(i).y))) &&
                    (point.x > (polygon.get(j).x - polygon.get(i).x) * (point.y - polygon.get(i).y) / (polygon.get(j).y - polygon.get(i).y) + polygon.get(i).x))
                res = !res;
            j=i;
        }

        return res;
    }

}


