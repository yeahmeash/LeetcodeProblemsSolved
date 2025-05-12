var cancellable = function(fn, args, t) {
    fn(...args); // Call fn immediately
    const timer = setInterval(() => fn(...args), t); // Set up the interval
    const cancelFn = () => clearInterval(timer); // Create the cancellation function
    return cancelFn; // Return the cancellation function
};
