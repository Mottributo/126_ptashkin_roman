public class Task_1 implements Task_1_base {
    double margin = 0.000001;
    @Override
    public int subtask_1_if(int first, int second, int third) {
        if ((first < second) && (first < third)) {
            return first;
        } else if ((second < third) && (second < first)) {
            return second;
        } else {
            // Если ни первое, ни второе число не минимально, то, методом исключения,
            // минимально третье. Если числа равны, то это вернет это равное число.
            return third;
        }
    }
    @Override
    public boolean subtask_2_if(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        // Проверить, является ли год, переданный в параметре year, високосным.
        // Високосный год - это год, кратный четырем, но не кратный 100, либо кратный 400.
    }
    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        if ((width <= 0) || (height <= 0)) {
            return 2;
            // Очевидно, что ширина и высота не могут быть отрицательными, иначе это приведет
            // к выворачиванию прямоугольника и нарушению условия того, что точка с координатами
            // left_up_x и left_up_y должна быть в левом верхнем углу.
        }
        else if ((Math.abs(x - left_up_x) < margin) ||
                (Math.abs(x - left_up_x - width) < margin) ||
                (Math.abs(y - left_up_y) < margin)  ||
                (Math.abs(y - left_up_y - height) < margin)) {
            return 0;
            // Срабатывает, когда точка погранична.
        }
        else if ((x > left_up_x) &&
                (x < left_up_x + width) &&
                (y < left_up_y) &&
                (y > left_up_y - height)) {
            return 1;
            // Срабатывает при нахождении точки внутри области.
        }
        else return 0;
        // Проверить, лежит ли точка с координатами (x, y) внутри невырожденного квадрата
        // со сторонами, параллельными осям координат, левый верхний угол которого имеет
        // координаты (left_up_x, left_up_y), ширина которого width, высота height.
        // Точка на границе считается не лежащей внутри.
        // В качестве результата вернуть:
        // 0 - не лежит
        // 1 - лежит
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
    }
    @Override
    public int subtask_4_if(double x0, double y0, double k, double b) {
        if (Math.abs(y0 - (k * x0 + b)) < margin) {
            return 2;
        }
        else if (y0 < (k * x0 + b)) {
            return 1;
        }
        else return 0;
        // Проверить, как расположена точка с координатами (x0, y0)
        // относительно прямой y = kx + b
        // В качестве результата вернуть:
        // 0 - лежит выше прямой
        // 1 - лежит ниже прямой
        // 2 - лежит на прямой
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
    }
    @Override
    public String subtask_5_switch(int day_od_week) {
        switch (day_od_week) {
            case 1: return "Понедельник";
            case 2: return "Вторник";
            case 3: return "Среда";
            case 4: return "Четверг";
            case 5: return "Пятница";
            case 6: return "Суббота";
            case 7: return "Воскресенье";
            default: return "Ошибка";
        }
        // По номеру дня недели day_od_week вернуть его название на русском языке, записанное
        // с большой буквы. Дни едели отсчитываются с единицы. Если номер задан некорректно,
        // вернуть строку "Ошибка".
    }
    @Override
    public String subtask_6_switch(int direction) {
        switch (direction) {
            case 1: return "север";
            case 2: return "юг";
            case 3: return "запад";
            case 4: return "восток";
            default: return "";
        }
        // По заданному направлению direction вернуть его название:
        // 1 - север
        // 2 - юг
        // 3 - запад
        // 4 - восток
        // Во всех остальных случаях вернуть пустую строку
    }
    @Override
    public int subtask_7_if(double vx, double vy, double vz, double speed, double time, double wall) {

        double pointY = (wall / vx) * vy;
        double pointZ = (wall / vx) * vz;
        double hypot3D = Math.sqrt(Math.pow(wall, 2) + Math.pow(pointY, 2) + Math.pow(pointZ, 2));

        if ((speed <= 0) || (time <= 0)) {
            return 2;
        }
        else if  (vx != 0) {
            if ((hypot3D / speed - time) > 0.000001)
                return 0;
            else
                return 1;
        }
        return 0;
        // Проверить, достигнет ли снаряд, летяший из точки (0, 0, 0)
        // в направлении (vx, vy, vz) со скоростью speed стены, параллельной плоскости OYZ,
        // имеющей координату x равной wall, за время time
        // 0 - не достигнет
        // 1 - достигнет
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
    }
    @Override
    public int subtask_8_if(double k1, double b1, double k2, double b2) {
        if (Math.abs(k1 - k2) < margin && Math.abs(b1 - b2) < margin) {
            return 3;
        }
        else if (Math.abs(k1 - k2) < margin) {
            return 1;
        }
        else return 2;
        // Проверить, как друг относительно друга располагаются прямые y = k1*x + b1 и
        // y = k2*x + b2. Вернуть
        // 1 - если параллельны
        // 2 - если пересекаются
        // 3 - если совпадают
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
    }
}
