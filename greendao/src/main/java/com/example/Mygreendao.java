package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Mygreendao {

        public static void main(String[] args) throws Exception {
            Schema schema = new Schema(1, "com.yfy.greendao");
            addNote(schema);
//            addContent(schema);
            new DaoGenerator().generateAll(schema, "/work/Lrean2017/app/src/main/java-gen");
        }

        /**
         * @param schema Lrean2017
         */
        private static void addNote(Schema schema) {
            Entity note = schema.addEntity("User");
            note.addIdProperty();
            note.addStringProperty("name").notNull();
            note.addStringProperty("type").notNull();
            note.addStringProperty("pass").notNull();
        }
}
