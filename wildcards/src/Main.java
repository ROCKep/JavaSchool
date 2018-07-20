import java.util.*;

public class Main {

    private static <T> void addAll(final Iterable<? extends T> src, final Collection<? super T> dest) {
        for (final T elem : src) {
            dest.add(elem);
        }
    }

    private static <T> int countContains(final Iterable<? extends T> src, final T element) {
        int count = 0;
        for (final T elem : src) {
            if (elem.equals(element)) {
                count++;
            }
        }
        return count;
    }

    private static <T> void mirror(final List<T> src) {
        final int last = src.size() - 1;
        T temp;
        for (int i = 0; i < src.size()/2; i++) {
            temp = src.get(i);
            src.set(i, src.get(last-i));
            src.set(last-i, temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Set<Integer> src1 = new LinkedHashSet<>();
        src1.add(3);
        src1.add(4);

        addAll(src1, list);
        System.out.println(list);

        System.out.println(countContains(list, 5));

        mirror(list);
        System.out.println(list);
    }
}
