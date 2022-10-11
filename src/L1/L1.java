package L1;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class L1 {
    // InMemoryModel
    public interface IModelChanger {
        public void NotifyChange(IModelChanger sender);
    }

    public interface IModelChangedObserver {
        public void ApplyUpdateModel();
    }

    /**
     * Класс Хранилище моделей, камер, сцен и источников света
     */
    public class ModelStore {
        /**
         * Хранилище моделей
         */
        public ArrayList<PoligonalModel> Models = new ArrayList<PoligonalModel>();
        /**
         * Хранилище сцен
         */
        public ArrayList<Scene> Scenes = new ArrayList<Scene>();
        /**
         * Хранилище источников света
         */
        public ArrayList<Flash> Flashes = new ArrayList<Flash>();
        /**
         * Хранилище камер
         */
        public ArrayList<Camera> Cameras = new ArrayList<Camera>();
        /**
         * Какая камера выбрана
         */
        private IModelChangedObserver changedObservers;

        /**
         * Возврат сцены по номеру
         *
         * @param value ID сцены
         * @return возвращаемая сцена, если нет такой то null
         */

        public Scene GetScena(int value) {
            return Scenes.stream().filter(t -> t.Id == value).findAny().orElse(null);
        }

        /**
         * Метод, уведомляющий об изменении в сцене, будет выполнять перерасчет сцен, пока заглушка
         *
         * @param value Какая модель изменилась
         */
        public void NotifyChange(IModelChanger value) {

        }
    }

    // ModelElements

    /**
     * Полигональная модель
     */
    public class PoligonalModel {
        /**
         * Хранилище полигонов модели
         */
        public ArrayList<Poligon> Poligones = new ArrayList<Poligon>();
        /**
         * Хранилище текстур модели
         */
        public ArrayList<Texture> Textures;
    }

    /**
     * Класс текстур
     */
    public class Texture {

    }

    /**
     * Класс полигонов
     */
    public class Poligon {
        /**
         * Положение полигона
         */
        public Point3D Points;
    }

    /**
     * Класс источника света
     */
    public class Flash {
        /**
         * Положение источника света
         */
        public Point3D Location;
        /**
         * Угол наклона источника света
         */
        public Angle3D Angle;
        /**
         * Цвет источник света
         */
        public Color Color;
        /**
         * Яркость источника света
         */
        public Float Power;

        /**
         * Метод, устанавливающий новый угол наклона
         *
         * @param value новый угол наклона (хз зачем, поле публичное)
         */
        public void Rotate(Angle3D value) {
            this.Angle = value;
        }

        /**
         * Метод устанавливающий новые координаты
         *
         * @param value новые координаты (хз зачем, поле публичное)
         */
        public void Move(Point3D value) {
            this.Location = value;
        }
    }

    /**
     * Класс камеры
     */
    public class Camera {
        /**
         * Положение камеры
         */
        public Point3D Location;
        /**
         * Угол наклона камеры
         */
        public Angle3D Angle;

        /**
         * Метод, устанавливающий новый угол наклона камеры
         *
         * @param value новый угол наклона (хз зачем, поле публичное)
         */
        public void Rotate(Angle3D value) {
            this.Angle = value;
        }

        /**
         * Метод, устанавливающий новое положение камеры
         *
         * @param value новое положение камеры (хз зачем, поле публичное)
         */
        public void Move(Point3D value) {
            this.Location = value;
        }
    }

    /**
     * Класс сцены, хранит данные используемых в ней камере, источнике света и модели
     */
    public class Scene {
        /**
         * счетчик созданных сцен, как генерировать уникальные ID не придумал по-другому
         */
        private static int count = 0;
        /**
         * ID сцены
         */
        public int Id;
        /**
         * Хранилище задействованных моделей
         */
        public ArrayList<PoligonalModel> Models;
        /**
         * Хранилище задействованных источников света
         */
        public ArrayList<Flash> Flashes;

        /**
         * Конструктор
         *
         * @param models  список задействованных моделей
         * @param flashes список задействованных источников света
         */
        Scene(ArrayList<PoligonalModel> models, ArrayList<Flash> flashes) {
            this.Id = count;
            count++;
            this.Models = models;
            this.Flashes = flashes;
        }

        /**
         * Метод заглушка, хз что должен делать
         *
         * @param value
         * @return
         */
        public Type method1(Type value) {
            return value;
        }

        /**
         * Метод заглушка, хз что должен делать
         *
         * @param value1
         * @param value2
         * @return
         */
        public Type method2(Type value1, Type value2) {
            return value1;
        }
    }

    // Заглушки Point3D и Angle3D

    /**
     * Заглушка класса угла
     */
    private class Angle3D {
    }

    /**
     * Заглушка класса положения
     */

    private class Point3D {
    }
}
