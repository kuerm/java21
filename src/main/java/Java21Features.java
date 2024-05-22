public class Java21Features {

    private static String getFishDescription(Fish f) {
        return "Fish details! Name: %s, Size: %s, Age: %s, Is Yummy? %s"
                .formatted(f.name(), f.size(), f.age(), f.yumminess());
    }

    private static String getBirdDescription(Bird b) {
        return "Bird details! Name: %s, Is Flying: %s"
                .formatted(b.name(), b.isFlying());
    }

    @SuppressWarnings("ConstantConditions")
    public String recordPatterns() {
        Fish salmon = new Fish(new FishName("Salmon"), 30.5, 3, FishYumminess.YUMMY);
        Bird eagle = new Bird("Eagle", true);

        StringBuilder sb = new StringBuilder();
        if (salmon instanceof Fish f) {
            sb.append(getFishDescription(f));
            sb.append("\n");
        }
        if (eagle instanceof Bird b) {
            sb.append(getBirdDescription(b));
            sb.append("\n");
        }

        // Here comes the fancy stuff
        if (salmon instanceof Fish(var name, var size, var age, var yumminess)) {
            // Direct access to the nested components of the record
            // you don't even need the Type name anymore - use var
            System.out.println(name.value());

            // With JEP443 you can replace unused vars with a single underscore
        }
        return sb.toString();
    }
}