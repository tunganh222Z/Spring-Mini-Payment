package com.util;

public class DbHelper {
    private StringBuilder sqlQuery;

    public DbHelper() {
        this.sqlQuery = new StringBuilder();
    }

    public static void main(String[] args) {
        DbHelper dbHelper = DbHelper.SqlQuery().select("123").from("user").where(
                WhereConditions.where("username").equal("tunganh"),
                WhereConditions.where("age").greaterEqual(18)
        );
        System.out.println(dbHelper.getQuery());
    }

    public static DbHelper SqlQuery(){
        return new DbHelper();
    }

    public String getQuery(){
        return sqlQuery.toString();
    }

    public DbHelper select(String select) {
        sqlQuery.append(String.format("SELECT %s ", select));
        return this;
    }

    public DbHelper where(WhereConditions... whereConditions) {
        String str = "WHERE 1=1 AND %s";
        StringBuilder conditions = new StringBuilder();

        for (int i = 0; i < whereConditions.length; i++) {
            conditions.append(whereConditions[i].getCondition() + " ");
            if (i < whereConditions.length - 1){
                conditions.append("AND ");
            }
        }
        sqlQuery.append(String.format(str, conditions));
        return this;
    }

    public DbHelper from(String table) {
        sqlQuery.append(String.format("FROM %s ", table));
        return this;
    }
}
