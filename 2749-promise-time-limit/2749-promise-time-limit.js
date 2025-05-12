/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
  // Return a function that takes arguments
  return (...args) => {
    // Create a timeout promise that rejects after `t` milliseconds
    const timeoutPromise = new Promise((resolve, reject) => {
      setTimeout(() => reject("Time Limit Exceeded"), t);
    });

    // Promise representing the function execution
    const fnPromise = fn(...args);

    // Return a promise that races the function execution against the timeout
    return Promise.race([fnPromise, timeoutPromise]);
  };
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */