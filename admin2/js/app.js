App = Ember.Application.create();

App.Router.map(function() {
  // put your routes here
  this.route("menu2", { path: "/menu2" });
  this.route("modulo1", { path: "/modulo1" });
  this.route("modulo2", { path: "/modulo2" });
  this.route("modulo3", { path: "/modulo3" });
  this.route("modulo4", { path: "/modulo4" });
});

App.IndexRoute = Ember.Route.extend({
  model: function() {
    return ['red', 'yellow', 'blue'];
  }
});
