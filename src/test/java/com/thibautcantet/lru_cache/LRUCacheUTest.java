package com.thibautcantet.lru_cache;


import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheUTest {

    @Nested
    class LinkedHashMapLRUCacheImplementation {
        @Test
        void get_should_return_and_remove_last_added_element() {
            LRUCache lrucache = new LinkedHashMapLRUCache(4);
            lrucache.set(1, 100);
            lrucache.set(10, 99);
            lrucache.set(15, 98);
            lrucache.set(10, 97);
            lrucache.set(12, 96);
            lrucache.set(18, 95);
            lrucache.set(1, 94);

            assertThat(lrucache.get(1)).isEqualTo(94);
            assertThat(lrucache.get(10)).isEqualTo(97);
            assertThat(lrucache.get(15)).isEqualTo(-1);
        }
    }

    @Nested
    class MyLRUCacheImplementation {

        @Test
        void get_should_return_and_remove_last_added_element() {
            final LRUCache lrucache = new MyLRUCache(4);
            lrucache.set(1, 100);
            lrucache.set(10, 99);
            lrucache.set(15, 98);
            lrucache.set(10, 97);
            lrucache.set(12, 96);
            lrucache.set(18, 95);
            lrucache.set(1, 94);

            assertThat(lrucache.get(1)).isEqualTo(94);
            assertThat(lrucache.get(10)).isEqualTo(97);
            assertThat(lrucache.get(15)).isEqualTo(-1);
        }

        @Test
        void get_should_return_value_and_remove_entry() {
            final MyLRUCache myLRUCache = new MyLRUCache(4);
            myLRUCache.set(1, 42);

            final int fetched = myLRUCache.get(1);

            assertThat(fetched).isEqualTo(42);
        }

        @Test
        void get_should_return_minus_one_when_entry_is_not_found() {
            final MyLRUCache myLRUCache = new MyLRUCache(4);

            final int fetched = myLRUCache.get(1);

            assertThat(fetched).isEqualTo(-1);
        }

        @Nested
        class SetShould {
            @Test
            void set_should_add_entry_when_no_existing_entry() {
                final MyLRUCache myLRUCache = new MyLRUCache(4);

                myLRUCache.set(1, 42);

                assertThat(myLRUCache.getHashMap()).containsExactly(MapEntry.entry(1, 42));
            }

            @Test
            void set_should_update_existing_entry() {
                final MyLRUCache myLRUCache = new MyLRUCache(4);

                myLRUCache.set(1, 0);
                myLRUCache.set(1, 42);

                assertThat(myLRUCache.getHashMap()).containsExactly(MapEntry.entry(1, 42));
            }

            @Test
            void set_should_add_second_entry_when_one_existing_entry() {
                final MyLRUCache myLRUCache = new MyLRUCache(4);

                myLRUCache.set(1, 42);
                myLRUCache.set(2, 24);

                assertThat(myLRUCache.getHashMap()).containsExactly(MapEntry.entry(1, 42), MapEntry.entry(2, 24));
            }

            @Test
            void set_should_add_third_entry_when_two_existing_entries() {
                final MyLRUCache myLRUCache = new MyLRUCache(4);

                myLRUCache.set(1, 42);
                myLRUCache.set(2, 24);
                myLRUCache.set(3, 12);

                assertThat(myLRUCache.getHashMap()).containsExactly(MapEntry.entry(1, 42), MapEntry.entry(2, 24), MapEntry.entry(3, 12));
            }

            @Test
            void set_should_add_fourth_entry_when_three_existing_entries() {
                final MyLRUCache myLRUCache = new MyLRUCache(4);

                myLRUCache.set(1, 42);
                myLRUCache.set(2, 24);
                myLRUCache.set(3, 12);
                myLRUCache.set(4, 6);

                assertThat(myLRUCache.getHashMap()).containsExactly(MapEntry.entry(1, 42), MapEntry.entry(2, 24), MapEntry.entry(3, 12), MapEntry.entry(4, 6));
            }

            @Test
            void set_should_evict_least_recently_used_entry() {
                final MyLRUCache myLRUCache = new MyLRUCache(4);

                myLRUCache.set(1, 42);
                myLRUCache.set(2, 24);
                myLRUCache.set(3, 12);
                myLRUCache.set(4, 6);
                myLRUCache.set(5, 3);

                assertThat(myLRUCache.getHashMap()).containsExactly(MapEntry.entry(1, 42), MapEntry.entry(2, 24), MapEntry.entry(3, 12), MapEntry.entry(5, 3));
            }
        }
    }
}