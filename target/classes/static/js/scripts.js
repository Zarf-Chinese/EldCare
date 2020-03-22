// Empty JS for your own code to be here
(function (global) {
        if (global.ec != null) return
        ec = {}
        ec.setIdentity = function (identityType) {
            $.post("/identity", {identityType: identityType})
        }
        ec.logout = function () {
            $.post("/user/logout")
        }
        ec.deleteUser = function () {
            $.post("/user/delete")
        }

        global.ec = ec;
    }
)(this)