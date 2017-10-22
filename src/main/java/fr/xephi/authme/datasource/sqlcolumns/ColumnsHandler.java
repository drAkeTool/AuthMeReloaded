package fr.xephi.authme.datasource.sqlcolumns;

import fr.xephi.authme.datasource.DataSourceResult;

/**
 * Handler which performs operations on the data source based on the given
 * columns and values.
 */
public interface ColumnsHandler<C, I> {

    /**
     * Retrieves the given column from a given row.
     *
     * @param identifier the id of the row to look up
     * @param column the column whose value should be retrieved
     * @param <T> the column type
     * @return the result of the lookup
     */
    <T> DataSourceResult<T> retrieve(I identifier, Column<T, C> column);

    /**
     * Retrieves multiple values from a given row.
     *
     * @param identifier the id of the row to look up
     * @param columns the columns to retrieve
     * @return map-like object with the requested values
     */
    DataSourceValues retrieve(I identifier, Column<?, C>... columns);

    /**
     * Changes a column from a specific row to the given value.
     *
     * @param identifier the id of the row to modify
     * @param column the column to modify
     * @param value the value to set the column to
     * @param <T> the column type
     * @return true upon success, false otherwise
     */
    <T> boolean update(String identifier, Column<T, C> column, T value);

    /**
     * Updates a row to have the given values.
     *
     * @param identifier the id of the row to modify
     * @param updateValues the values to set on the row
     * @return true upon success, false otherwise
     */
    boolean update(I identifier, UpdateValues<C> updateValues);

    /**
     * Updates a row to have the values as retrieved from the dependent object.
     *
     * @param identifier the id of the row to modify
     * @param dependent the dependent to get values from
     * @param columns the columns to update in the row
     * @param <D> the dependent type
     * @return true upon success, false otherwise
     */
    <D> boolean update(I identifier, D dependent, DependentColumn<?, C, D>... columns);

}
