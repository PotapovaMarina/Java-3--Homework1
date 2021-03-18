    import java.util.ArrayList;
    /*
    Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
    Класс Box, в который можно складывать фрукты. Коробки условно сортируются
    по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

    Для хранения фруктов внутри коробки можно использовать ArrayList;
    Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов
    и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);

    Внутри класса Коробка сделать метод compare, который позволяет сравнить
    текущую коробку с той, которую подадут в compare в качестве параметра,
    true – если она равны по весу, false – в противном случае
    (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    Написать метод, который позволяет пересыпать фрукты из текущей коробки
    в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    Не забываем про метод добавления фрукта в коробку.

    */

    public class Box<T extends Fruit> {
        public ArrayList<T> fruitBox=new ArrayList<>();
        int capacity;

        public Box(int capacity) {
            this.capacity = capacity;
        }

        //Сделать метод getWeight(), который
        // высчитывает вес коробки, зная количество фруктов и вес одного фрукта
        // (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
        public float getWeight() {
            float weight = 0.0f;
            for (T el : this.fruitBox) {
                weight += el.getWeightOfOneFruit();
            }
            return weight;
        }

        //добавление фрукта в коробку
        public void addFruit(T fruit, int qty) {
            if(qty<=capacity) {
                for (int i = 0; i < qty; i++) {
                    this.fruitBox.add(fruit);
                }
                capacity-=qty;
            }
            else{
                System.out.println("вместимость коробки "+capacity+" меньше чем "+qty);
            }
        }
        // Внутри класса Коробка сделать метод compare, который позволяет сравнить
        //текущую коробку с той, которую подадут в compare в качестве параметра,
        //true – если она равны по весу, false – в противном случае
        //(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        public boolean compare (Box<?> anotherBox){
            return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.001;
        }

        /*
        Написать метод, который позволяет пересыпать фрукты из текущей коробки
        в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
         */
        public void fillBox(Box<T> anotherBox){
            if (anotherBox.capacity> fruitBox.size()) {
                anotherBox.fruitBox.addAll(fruitBox);
                fruitBox.clear();
            }
            else{anotherBox.fruitBox.addAll(fruitBox.subList(0, anotherBox.capacity));
                fruitBox.removeAll(fruitBox.subList(0, anotherBox.capacity));
            }
            anotherBox.capacity-=fruitBox.size();
            capacity+= fruitBox.size();

        }
    }

