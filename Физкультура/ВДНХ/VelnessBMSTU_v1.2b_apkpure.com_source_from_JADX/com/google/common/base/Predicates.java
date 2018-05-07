package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Predicates {
    private static final Joiner COMMA_JOINER = Joiner.on(',');

    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        private AndPredicate(List<? extends Predicate<? super T>> components) {
            this.components = components;
        }

        public boolean apply(@Nullable T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!((Predicate) this.components.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof AndPredicate)) {
                return false;
            }
            return this.components.equals(((AndPredicate) obj).components);
        }

        public String toString() {
            return "Predicates.and(" + Predicates.COMMA_JOINER.join(this.components) + ")";
        }
    }

    @GwtIncompatible("Class.isAssignableFrom")
    private static class AssignableFromPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        private AssignableFromPredicate(Class<?> clazz) {
            this.clazz = (Class) Preconditions.checkNotNull(clazz);
        }

        public boolean apply(Class<?> input) {
            return this.clazz.isAssignableFrom(input);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof AssignableFromPredicate)) {
                return false;
            }
            if (this.clazz == ((AssignableFromPredicate) obj).clazz) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Predicates.assignableFrom(" + this.clazz.getName() + ")";
        }
    }

    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<A, ? extends B> f23f;
        final Predicate<B> f24p;

        private CompositionPredicate(Predicate<B> p, Function<A, ? extends B> f) {
            this.f24p = (Predicate) Preconditions.checkNotNull(p);
            this.f23f = (Function) Preconditions.checkNotNull(f);
        }

        public boolean apply(@Nullable A a) {
            return this.f24p.apply(this.f23f.apply(a));
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate<?, ?> that = (CompositionPredicate) obj;
            if (this.f23f.equals(that.f23f) && this.f24p.equals(that.f24p)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f23f.hashCode() ^ this.f24p.hashCode();
        }

        public String toString() {
            return this.f24p.toString() + "(" + this.f23f.toString() + ")";
        }
    }

    @GwtIncompatible("Only used by other GWT-incompatible code.")
    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final Pattern pattern;

        ContainsPatternPredicate(Pattern pattern) {
            this.pattern = (Pattern) Preconditions.checkNotNull(pattern);
        }

        public boolean apply(CharSequence t) {
            return this.pattern.matcher(t).find();
        }

        public int hashCode() {
            return Objects.hashCode(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate that = (ContainsPatternPredicate) obj;
            if (Objects.equal(this.pattern.pattern(), that.pattern.pattern()) && Objects.equal(Integer.valueOf(this.pattern.flags()), Integer.valueOf(that.pattern.flags()))) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Predicates.contains(" + Objects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString() + ")";
        }
    }

    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        private InPredicate(Collection<?> target) {
            this.target = (Collection) Preconditions.checkNotNull(target);
        }

        public boolean apply(@Nullable T t) {
            boolean z = false;
            try {
                z = this.target.contains(t);
            } catch (NullPointerException e) {
            } catch (ClassCastException e2) {
            }
            return z;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof InPredicate)) {
                return false;
            }
            return this.target.equals(((InPredicate) obj).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    @GwtIncompatible("Class.isInstance")
    private static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        private InstanceOfPredicate(Class<?> clazz) {
            this.clazz = (Class) Preconditions.checkNotNull(clazz);
        }

        public boolean apply(@Nullable Object o) {
            return this.clazz.isInstance(o);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof InstanceOfPredicate)) {
                return false;
            }
            if (this.clazz == ((InstanceOfPredicate) obj).clazz) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }
    }

    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        private IsEqualToPredicate(T target) {
            this.target = target;
        }

        public boolean apply(T t) {
            return this.target.equals(t);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof IsEqualToPredicate)) {
                return false;
            }
            return this.target.equals(((IsEqualToPredicate) obj).target);
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }
    }

    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        public boolean apply(@Nullable T t) {
            return !this.predicate.apply(t);
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof NotPredicate)) {
                return false;
            }
            return this.predicate.equals(((NotPredicate) obj).predicate);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate.toString() + ")";
        }
    }

    enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE {
            public boolean apply(@Nullable Object o) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public boolean apply(@Nullable Object o) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public boolean apply(@Nullable Object o) {
                return o == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public boolean apply(@Nullable Object o) {
                return o != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        private OrPredicate(List<? extends Predicate<? super T>> components) {
            this.components = components;
        }

        public boolean apply(@Nullable T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (((Predicate) this.components.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof OrPredicate)) {
                return false;
            }
            return this.components.equals(((OrPredicate) obj).components);
        }

        public String toString() {
            return "Predicates.or(" + Predicates.COMMA_JOINER.join(this.components) + ")";
        }
    }

    @GwtIncompatible("Only used by other GWT-incompatible code.")
    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String string) {
            super(Pattern.compile(string));
        }

        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    private Predicates() {
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> components) {
        return new AndPredicate(defensiveCopy((Iterable) components));
    }

    public static <T> Predicate<T> and(Predicate<? super T>... components) {
        return new AndPredicate(defensiveCopy((Object[]) components));
    }

    public static <T> Predicate<T> and(Predicate<? super T> first, Predicate<? super T> second) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(first), (Predicate) Preconditions.checkNotNull(second)));
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> components) {
        return new OrPredicate(defensiveCopy((Iterable) components));
    }

    public static <T> Predicate<T> or(Predicate<? super T>... components) {
        return new OrPredicate(defensiveCopy((Object[]) components));
    }

    public static <T> Predicate<T> or(Predicate<? super T> first, Predicate<? super T> second) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(first), (Predicate) Preconditions.checkNotNull(second)));
    }

    public static <T> Predicate<T> equalTo(@Nullable T target) {
        return target == null ? isNull() : new IsEqualToPredicate(target);
    }

    @GwtIncompatible("Class.isInstance")
    public static Predicate<Object> instanceOf(Class<?> clazz) {
        return new InstanceOfPredicate(clazz);
    }

    @GwtIncompatible("Class.isAssignableFrom")
    @Beta
    public static Predicate<Class<?>> assignableFrom(Class<?> clazz) {
        return new AssignableFromPredicate(clazz);
    }

    public static <T> Predicate<T> in(Collection<? extends T> target) {
        return new InPredicate(target);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> containsPattern(String pattern) {
        return new ContainsPatternFromStringPredicate(pattern);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new ContainsPatternPredicate(pattern);
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> first, Predicate<? super T> second) {
        return Arrays.asList(new Predicate[]{first, second});
    }

    private static <T> List<T> defensiveCopy(T... array) {
        return defensiveCopy(Arrays.asList(array));
    }

    static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList();
        for (T element : iterable) {
            list.add(Preconditions.checkNotNull(element));
        }
        return list;
    }
}
