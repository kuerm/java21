public class Java21Features {

    public String plainSwitch(Animal animal) {
        return switch (animal) {
            case Dog dog -> "dog %s".formatted(dog.name());
            case Cat cat -> "cat %s".formatted(cat.name());
            case Mouse __ -> "mouse"; // __ = poor man's unnamed pattern variable
        };
    }

    public String plainSwitchWithDefault(Object object) {
        return switch (object) {
            case Dog dog -> "dog %s".formatted(dog.name());
            case Cat cat -> "cat %s".formatted(cat.name());
            case Integer i -> "int %d".formatted(i);
            default -> "unknown";
        };
    }

    public String plainSwitchWithNull(Object object) {
        return switch (object) {
            case Dog dog -> "dog %s".formatted(dog.name());
            case Cat cat -> "cat %s".formatted(cat.name());
            case null -> "null";
            default -> "unknown";
        };
    }

    public String plainSwitchWithCondition(Animal animal) {
        return switch (animal) {
            case Dog dog when dog.name().equals("Rex") -> "Kommissar Rex";
            // try to remove next line and see what happens
            case Dog dog -> "dog %s".formatted(dog.name());
            case Cat cat -> "cat %s".formatted(cat.name());
            case Mouse __ -> "mouse";
        };
    }

    static final class Cat extends Animal {
        private Cat(String name) {
            super(name);
        }

        public static Cat of(String name) {
            return new Cat(name);
        }
    }

    static final class Mouse extends Animal {
        private Mouse(String name) {
            super(name);
        }

        public static Mouse of(String name) {
            return new Mouse(name);
        }

    }

    static final class Dog extends Animal {
        private Dog(String name) {
            super(name);
        }

        public static Dog of(String name) {
            return new Dog(name);
        }
    }

    // try to remove the permits clause and see what happens
    sealed abstract static class Animal permits Cat, Dog, Mouse {
        private String name;

        protected Animal(String name) {
            this.name = name;
        }

        public String name() {
            return name;
        }
    }
}
