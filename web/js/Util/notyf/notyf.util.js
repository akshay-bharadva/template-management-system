/**
 * @config
 * @position : top right corner
 * @types : Success, Error, Info, Warning
 * 
 * @libraries : https://carlosroso.com/notyf/
 * |-@style : https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css
 * |-@icon : https://fonts.googleapis.com/icon?family=Material+Icons
 * |-@javascript : https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js
 * |-@utility : notyf.util.js
 */

var NOTYF = new Notyf({
  duration: 5000,
  position: {
    x: "right",
    y: "top",
  },
  types: [
    {
      type: "warning",
      background: `linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%)`,
      icon: {
        className: "material-icons",
        tagName: "i",
        text: "warning",
      },
    },
    {
      type: "info",
      background: `linear-gradient(160deg, #0093E9 0%, #80D0C7 100%)`,
      icon: {
        className: "material-icons",
        tagName: "i",
        text: "info",
      },
    },
  ],
  ripple: false,
});

/**
 * @function {Generic Function for Notification}
 */
function showNotyf(message, type, dismissible = false) {
  NOTYF.open({
    type,
    dismissible,
    message,
  });
}

/**
 * @param {dismiss,click} eventType
 * @param {Based on event Callback} callback 
 */
function showNotyfCallback(
  message,
  type,
  dismissible = false,
  eventType="dismiss",
  callback = null
) {
  NOTYF
    .open({
      type,
      dismissible,
      message,
    })
    .on(eventType, ({ target, event }) => callback({target, event}));
}