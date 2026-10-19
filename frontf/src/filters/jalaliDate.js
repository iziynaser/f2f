// src/filters/jalaliDate.js
import moment from 'moment-jalaali';

export function jalaliDate(value, format = 'jYYYY/jMM/jDD HH:mm') {
    if (!value) return '-';
    return moment(value).format(format);
}
