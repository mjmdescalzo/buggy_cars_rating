# Critical Bugs
## Bug no. 1
**Summary:** When user is in the profile page, when user logs out, the profile page is still viewable

**Steps to recreate:** <br/>
1. Login with valid credentials
2. Navigate to the Profile page
3. Click Logout

**Expected results:** <br/>
Profile page should no longer be visible as this is a user only page with sensitive data

**Actual results:** <br/>
Profile page is still visible even though the user is already logged out

___
## Bug no. 2
**Summary:** When a user logs in on one tab, another user is still able to login on another tab with different credentials, and the first user is then logged out

**Steps to recreate:** <br/>
1. Open 2 tabs with user not logged in
2. Login on one tab
3. Login on the other tab with a different credentials

**Expected results:** <br/>
User should no longer be able to login on the second tab, first logged in use should be maintained

**Actual results:** <br/>
User is still able to login on the second tab, and the first user is then logged out

___
## Bug no. 3
**Summary:** User is not able to logout when in the Overall ratings page

**Steps to recreate:** <br/>
1. Login with valid credentials
2. Navigate to Overall ratings
3. Click Logout

**Expected results:** <br/>
User should be able to logout

**Actual results:** <br/>
User is not able to logout, no response when clicking the button