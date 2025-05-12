/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        const result = [];
        for (const item of obj) {
            if (Boolean(item)) {
                if (typeof item === 'object' && item !== null) {
                    result.push(compactObject(item));
                } else {
                    result.push(item);
                }
            }
        }
        return result;
    } else if (typeof obj === 'object' && obj !== null) {
        const result = {};
        for (const key in obj) {
            if (Boolean(obj[key])) {
                if (typeof obj[key] === 'object' && obj[key] !== null) {
                    result[key] = compactObject(obj[key]);
                } else {
                    result[key] = obj[key];
                }
            }
        }
        return result;
    } else {
        return obj;
    }
};