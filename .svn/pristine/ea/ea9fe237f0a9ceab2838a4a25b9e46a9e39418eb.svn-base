
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <viewer-pdf-toolbar id="toolbar" style="transform-origin: 50% 0px 0px; transform: none;">
        <div id="sizer" style="width: 803px; height: 2324px;"></div>
        <viewer-password-screen id="password-screen">
            <style scope="viewer-password-screen">
                [hidden] {
                display: none !important;
            }

            :host-context([dir=rtl]) :-webkit-any(paper-icon-button-light, .cr-icon) {
                transform: scaleX(-1);
            }

            paper-icon-button-light paper-ripple {
                color: currentColor;
                opacity: 0.6;
            }

            paper-icon-button-light, .cr-icon {
                -webkit-margin-end: var(--cr-paper-icon-button-margin_-_-webkit-margin-end); -webkit-margin-start: var(--cr-paper-icon-button-margin_-_-webkit-margin-start);
                background-position: center;
                background-repeat: no-repeat;
                background-size: var(--cr-icon-size);
                flex-shrink: 0;
                height: var(--cr-icon-ripple-size);
                user-select: none;
                width: var(--cr-icon-ripple-size);
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).no-overlap {
                margin-left: 0;
                margin-right: 0;
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-arrow-back {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMjAgMTFINy44M2w1LjU5LTUuNTlMMTIgNGwtOCA4IDggOCAxLjQxLTEuNDFMNy44MyAxM0gyMHYtMnoiPjwvcGF0aD48L3N2Zz4=');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-cancel {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDIgNCIgZmlsbD0iIzc1NzU3NSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ieE1pZFlNaWQgbWVldCI+PHBhdGggZD0iTTEyIDJDNi40NyAyIDIgNi40NyAyIDEyczQuNDcgMTAgMTAgMTAgMTAtNC40NyAxMC0xMFMxNy41MyAyIDEyIDJ6bTUgMTMuNTlMMTUuNTkgMTcgMTIgMTMuNDEgOC40MSAxNyA3IDE1LjU5IDEwLjU5IDEyIDcgOC40MSA4LjQxIDcgMTIgMTAuNTkgMTUuNTkgNyAxNyA4LjQxIDEzLjQxIDEyIDE3IDE1LjU5eiIgLz48L3N2Zz4K');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-cancel-toolbar {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDIgNCIgZmlsbD0iI2ZmZmZmZiIgcHJlc2VydmVBc3BlY3RSYXRpbz0ieE1pZFlNaWQgbWVldCI+PHBhdGggZD0iTTEyIDJDNi40NyAyIDIgNi40NyAyIDEyczQuNDcgMTAgMTAgMTAgMTAtNC40NyAxMC0xMFMxNy41MyAyIDEyIDJ6bTUgMTMuNTlMMTUuNTkgMTcgMTIgMTMuNDEgOC40MSAxNyA3IDE1LjU5IDEwLjU5IDEyIDcgOC40MSA4LjQxIDcgMTIgMTAuNTkgMTUuNTkgNyAxNyA4LjQxIDEzLjQxIDEyIDE3IDE1LjU5eiIgLz48L3N2Zz4K');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-clear {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTkgNi40MUwxNy41OSA1IDEyIDEwLjU5IDYuNDEgNSA1IDYuNDEgMTAuNTkgMTIgNSAxNy41OSA2LjQxIDE5IDEyIDEzLjQxIDE3LjU5IDE5IDE5IDE3LjU5IDEzLjQxIDEyeiI+PC9wYXRoPjwvc3ZnPg==');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-delete-gray {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNNiAxOWMwIDEuMS45IDIgMiAyaDhjMS4xIDAgMi0uOSAyLTJWN0g2djEyek0xOSA0aC0zLjVsLTEtMWgtNWwtMSAxSDV2MmgxNFY0eiI+PC9wYXRoPjwvc3ZnPgo=');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-delete-white {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjZmZmZmZmIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNNiAxOWMwIDEuMS45IDIgMiAyaDhjMS4xIDAgMi0uOSAyLTJWN0g2djEyek0xOSA0aC0zLjVsLTEtMWgtNWwtMSAxSDV2MmgxNFY0eiI+PC9wYXRoPjwvc3ZnPgo=');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-expand-less {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIGZpbGw9IiM3NTc1NzUiIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIKICAgIHZpZXdib3g9IjAgMCAyNCAyNCI+CiAgPHBhdGggZD0iTTEyIDhsLTYgNiAxLjQxIDEuNDFMMTIgMTAuODNsNC41OSA0LjU4TDE4IDE0eiI+PC9wYXRoPgo8L3N2Zz4K');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-expand-more {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIGZpbGw9IiM3NTc1NzUiIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIKICAgIHZpZXdCb3g9IjAgMCAyNCAyNCI+CiAgPHBhdGggZD0iTTE2LjU5IDguNTlMMTIgMTMuMTcgNy40MSA4LjU5IDYgMTBsNiA2IDYtNnoiPjwvcGF0aD4KPC9zdmc+Cg==');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-external {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjYmRiZGJkIj48cGF0aCBkPSJNMTkgMTlINVY1aDdWM0g1YTIgMiAwIDAgMC0yIDJ2MTRhMiAyIDAgMCAwIDIgMmgxNGMxLjEgMCAyLS45IDItMnYtN2gtMnY3ek0xNCAzdjJoMy41OWwtOS44MyA5LjgzIDEuNDEgMS40MUwxOSA2LjQxVjEwaDJWM2gtN3oiLz48L3N2Zz4=');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-menu-white {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyMCIgaGVpZ2h0PSIyMCIgdmlld0JveD0iMCAwIDIwIDIwIiBmaWxsPSIjZmZmIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cmVjdCB4PSIyIiB5PSI0IiB3aWR0aD0iMTYiIGhlaWdodD0iMiI+PC9yZWN0PjxyZWN0IHg9IjIiIHk9IjkiIHdpZHRoPSIxNiIgaGVpZ2h0PSIyIj48L3JlY3Q+PHJlY3QgeD0iMiIgeT0iMTQiIHdpZHRoPSIxNiIgaGVpZ2h0PSIyIj48L3JlY3Q+PC9zdmc+');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-more-vert {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTIgOGMxLjEgMCAyLS45IDItMnMtLjktMi0yLTItMiAuOS0yIDIgLjkgMiAyIDJ6bTAgMmMtMS4xIDAtMiAuOS0yIDJzLjkgMiAyIDIgMi0uOSAyLTItLjktMi0yLTJ6bTAgNmMtMS4xIDAtMiAuOS0yIDJzLjkgMiAyIDIgMi0uOSAyLTItLjktMi0yLTJ6Ij48L3BhdGg+PC9zdmc+');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-refresh {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTcuNjUgNi4zNUMxNi4yIDQuOSAxNC4yMSA0IDEyIDRjLTQuNDIgMC03Ljk5IDMuNTgtNy45OSA4czMuNTcgOCA3Ljk5IDhjMy43MyAwIDYuODQtMi41NSA3LjczLTZoLTIuMDhjLS44MiAyLjMzLTMuMDQgNC01LjY1IDQtMy4zMSAwLTYtMi42OS02LTZzMi42OS02IDYtNmMxLjY2IDAgMy4xNC42OSA0LjIyIDEuNzhMMTMgMTFoN1Y0bC0yLjM1IDIuMzV6Ij48L3BhdGg+PC9zdmc+');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-settings {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTkuNDMgMTIuOThjLjA0LS4zMi4wNy0uNjQuMDctLjk4cy0uMDMtLjY2LS4wNy0uOThsMi4xMS0xLjY1Yy4xOS0uMTUuMjQtLjQyLjEyLS42NGwtMi0zLjQ2Yy0uMTItLjIyLS4zOS0uMy0uNjEtLjIybC0yLjQ5IDFjLS41Mi0uNC0xLjA4LS43My0xLjY5LS45OGwtLjM4LTIuNjVDMTQuNDYgMi4xOCAxNC4yNSAyIDE0IDJoLTRjLS4yNSAwLS40Ni4xOC0uNDkuNDJsLS4zOCAyLjY1Yy0uNjEuMjUtMS4xNy41OS0xLjY5Ljk4bC0yLjQ5LTFjLS4yMy0uMDktLjQ5IDAtLjYxLjIybC0yIDMuNDZjLS4xMy4yMi0uMDcuNDkuMTIuNjRsMi4xMSAxLjY1Yy0uMDQuMzItLjA3LjY1LS4wNy45OHMuMDMuNjYuMDcuOThsLTIuMTEgMS42NWMtLjE5LjE1LS4yNC40Mi0uMTIuNjRsMiAzLjQ2Yy4xMi4yMi4zOS4zLjYxLjIybDIuNDktMWMuNTIuNCAxLjA4LjczIDEuNjkuOThsLjM4IDIuNjVjLjAzLjI0LjI0LjQyLjQ5LjQyaDRjLjI1IDAgLjQ2LS4xOC40OS0uNDJsLjM4LTIuNjVjLjYxLS4yNSAxLjE3LS41OSAxLjY5LS45OGwyLjQ5IDFjLjIzLjA5LjQ5IDAgLjYxLS4yMmwyLTMuNDZjLjEyLS4yMi4wNy0uNDktLjEyLS42NGwtMi4xMS0xLjY1ek0xMiAxNS41Yy0xLjkzIDAtMy41LTEuNTctMy41LTMuNXMxLjU3LTMuNSAzLjUtMy41IDMuNSAxLjU3IDMuNSAzLjUtMS41NyAzLjUtMy41IDMuNXoiPjwvcGF0aD48L3N2Zz4=');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-search {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTUuNSAxNGgtLjc5bC0uMjgtLjI3QzE1LjQxIDEyLjU5IDE2IDExLjExIDE2IDkuNSAxNiA1LjkxIDEzLjA5IDMgOS41IDNTMyA1LjkxIDMgOS41IDUuOTEgMTYgOS41IDE2YzEuNjEgMCAzLjA5LS41OSA0LjIzLTEuNTdsLjI3LjI4di43OWw1IDQuOTlMMjAuNDkgMTlsLTQuOTktNXptLTYgMEM3LjAxIDE0IDUgMTEuOTkgNSA5LjVTNy4wMSA1IDkuNSA1IDE0IDcuMDEgMTQgOS41IDExLjk5IDE0IDkuNSAxNHoiPjwvcGF0aD48L3N2Zz4=');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-arrow-dropdown {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNNyAxMGw1IDUgNS01eiI+PC9wYXRoPjwvc3ZnPg==');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).subpage-arrow {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1Ij48cGF0aCBkPSJNMTAgN2w1IDUtNSA1eiIvPjwvc3ZnPg==');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-visibility {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTIgNC41QzcgNC41IDIuNzMgNy42MSAxIDEyYzEuNzMgNC4zOSA2IDcuNSAxMSA3LjVzOS4yNy0zLjExIDExLTcuNWMtMS43My00LjM5LTYtNy41LTExLTcuNXpNMTIgMTdjLTIuNzYgMC01LTIuMjQtNS01czIuMjQtNSA1LTUgNSAyLjI0IDUgNS0yLjI0IDUtNSA1em0wLThjLTEuNjYgMC0zIDEuMzQtMyAzczEuMzQgMyAzIDMgMy0xLjM0IDMtMy0xLjM0LTMtMy0zeiI+PC9wYXRoPjwvc3ZnPg==');
            }

            :-webkit-any(paper-icon-button-light, .cr-icon).icon-visibility-off {
                background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTIgN2MyLjc2IDAgNSAyLjI0IDUgNSAwIC42NS0uMTMgMS4yNi0uMzYgMS44M2wyLjkyIDIuOTJjMS41MS0xLjI2IDIuNy0yLjg5IDMuNDMtNC43NS0xLjczLTQuMzktNi03LjUtMTEtNy41LTEuNCAwLTIuNzQuMjUtMy45OC43bDIuMTYgMi4xNkMxMC43NCA3LjEzIDExLjM1IDcgMTIgN3pNMiA0LjI3bDIuMjggMi4yOC40Ni40NkMzLjA4IDguMyAxLjc4IDEwLjAyIDEgMTJjMS43MyA0LjM5IDYgNy41IDExIDcuNSAxLjU1IDAgMy4wMy0uMyA0LjM4LS44NGwuNDIuNDJMMTkuNzMgMjIgMjEgMjAuNzMgMy4yNyAzIDIgNC4yN3pNNy41MyA5LjhsMS41NSAxLjU1Yy0uMDUuMjEtLjA4LjQzLS4wOC42NSAwIDEuNjYgMS4zNCAzIDMgMyAuMjIgMCAuNDQtLjAzLjY1LS4wOGwxLjU1IDEuNTVjLS42Ny4zMy0xLjQxLjUzLTIuMi41My0yLjc2IDAtNS0yLjI0LTUtNSAwLS43OS4yLTEuNTMuNTMtMi4yem00LjMxLS43OGwzLjE1IDMuMTUuMDItLjE2YzAtMS42Ni0xLjM0LTMtMy0zbC0uMTcuMDF6Ii8+PC9zdmc+Cg==');
            }

            .action-button {
                background: var(--google-blue-500);
                color: white;
                --paper-button-flat-keyboard-focus_-_background:  rgb(58, 117, 215);;
            }

            .action-button[disabled] {
                opacity: .2;
            }

            .cancel-button {
                --paper-button-flat-keyboard-focus_-_background:  rgba(0, 0, 0, .12);;
                -webkit-margin-end: 8px;
                color: var(--paper-grey-600);
            }

            .action-button, .cancel-button {
                font-weight: 500;
                line-height: 154%;
                padding: 8px 16px;
            }

            [actionable] {
                cursor: var(--cr-actionable_-_cursor);
            }

            .subpage-arrow, .icon-external {
                display: none;
            }

            [actionable] :-webkit-any(.subpage-arrow, .icon-external), [actionable]:-webkit-any(.subpage-arrow, .icon-external) {
                display: block;
            }

            .hr {
                border-top: var(--cr-separator-line);
            }

            iron-list.cr-separators > *:not([first]) {
                border-top: var(--cr-separator-line);
            }

            [scrollable] {
                border-color: transparent;
                border-style: solid;
                border-width: 1px 0;
                overflow-y: auto;
            }

            [scrollable].is-scrolled {
                border-top-color: var(--google-grey-300);
            }

            [scrollable].can-scroll:not(.scrolled-to-bottom) {
                border-bottom-color: var(--google-grey-300);
            }

            [scrollable] iron-list > :not(.no-outline):focus {
            ;
                background-color: var(--cr-selectable-focus_-_background-color); outline: var(--cr-selectable-focus_-_outline);
            }

            .scroll-container {
                display: flex;
                flex-direction: column;
                min-height: 1px;
            }

            [selectable]:focus, [selectable] > :focus {
                background-color: var(--cr-selectable-focus_-_background-color); outline: var(--cr-selectable-focus_-_outline);
            }

            [selectable] > * {
                cursor: var(--cr-actionable_-_cursor);
            }

            #cr-container-shadow {
                box-shadow: var(--cr-container-shadow_-_box-shadow); height: var(--cr-container-shadow_-_height); left: var(--cr-container-shadow_-_left); margin-bottom: var(--cr-container-shadow_-_margin-bottom); opacity: var(--cr-container-shadow_-_opacity); pointer-events: var(--cr-container-shadow_-_pointer-events); position: var(--cr-container-shadow_-_position); right: var(--cr-container-shadow_-_right); top: var(--cr-container-shadow_-_top); transition: var(--cr-container-shadow_-_transition); z-index: var(--cr-container-shadow_-_z-index);
            }

            #cr-container-shadow.has-shadow {
                opacity: var(--cr-container-shadow-max-opacity);
            }

            #password {
                --paper-input-container-focus-color: var(--google-blue-500);
                --paper-input-container-input_-_font-size: apply-shim-inherit;;
            }</style>
            <cr-dialog id="dialog" no-cancel="">
                <div slot="title">需要密码</div>
                <div slot="body">
                    <div id="message">本文档设置了密码保护，请输入密码。</div>
                    <paper-input id="password" type="password" no-label-float="" autofocus="" tabindex="0" aria-disabled="false">
                    </paper-input>
                </div>
                <div slot="button-container">
                    <paper-button id="submit" class="action-button" role="button" tabindex="0" animated="" aria-disabled="false" elevation="0">
                        提交
                    </paper-button>
                </div>
            </cr-dialog>

        </viewer-password-screen>
    </viewer-pdf-toolbar>
    <viewer-zoom-toolbar id="zoom-toolbar" style="right: -8.5px; bottom: 0px;">
        <style scope="viewer-zoom-toolbar">:host {
            bottom: 0;
            padding: 48px 0;
            position: fixed;
            right: 0;
            user-select: none;
            z-index: 3;
        }

        :host-context([dir=rtl]) {
            left: 0;
            right: auto;
        }

        #zoom-buttons {
            position: relative;
            right: 48px;
        }

        :host-context([dir=rtl]) #zoom-buttons {
            left: 48px;
            right: auto;
        }

        viewer-zoom-button {
            display: block;
        }

        #zoom-out-button {
            margin-top: 10px;
        }

        #zoom-in-button {
            margin-top: 24px;
        }</style>
        <div id="zoom-buttons">
            <viewer-zoom-button id="fit-button" delay="100" icons="pdf:fullscreen-exit cr:fullscreen">
            </viewer-zoom-button>
            <viewer-zoom-button id="zoom-in-button" icons="pdf:add" delay="50"></viewer-zoom-button>
            <viewer-zoom-button id="zoom-out-button" icons="pdf:remove" delay="0"></viewer-zoom-button>
        </div>
    </viewer-zoom-toolbar>
    <viewer-page-indicator id="page-indicator">
        <style scope="viewer-page-indicator">:host {
            pointer-events: none;
            position: fixed;
            right: 0;
            transition: opacity 400ms ease-in-out;
        }

        #text {
            background-color: rgba(0, 0, 0, 0.5);
            border-radius: 5px;
            color: white;
            float: left;
            font-family: sans-serif;
            font-size: 12px;
            font-weight: bold;
            line-height: 48px;
            text-align: center;
            text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.8);
            width: 62px;
        }

        #triangle-right {
            border-bottom: 6px solid transparent;
            border-left: 8px solid rgba(0, 0, 0, 0.5);
            border-top: 6px solid transparent;
            display: inline;
            float: left;
            height: 0;
            margin-top: 18px;
            width: 0;
        }</style>
        <div id="text">NaN</div>
        <div id="triangle-right"></div>
    </viewer-page-indicator>
    <viewer-error-screen id="error-screen">
        <style scope="viewer-error-screen">[hidden] {
            display: none !important;
        }

        :host-context([dir=rtl]) :-webkit-any(paper-icon-button-light, .cr-icon) {
            transform: scaleX(-1);
        }

        paper-icon-button-light paper-ripple {
            color: currentColor;
            opacity: 0.6;
        }

        paper-icon-button-light, .cr-icon {
            -webkit-margin-end: var(--cr-paper-icon-button-margin_-_-webkit-margin-end); -webkit-margin-start: var(--cr-paper-icon-button-margin_-_-webkit-margin-start);
            background-position: center;
            background-repeat: no-repeat;
            background-size: var(--cr-icon-size);
            flex-shrink: 0;
            height: var(--cr-icon-ripple-size);
            user-select: none;
            width: var(--cr-icon-ripple-size);
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).no-overlap {
            margin-left: 0;
            margin-right: 0;
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-arrow-back {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMjAgMTFINy44M2w1LjU5LTUuNTlMMTIgNGwtOCA4IDggOCAxLjQxLTEuNDFMNy44MyAxM0gyMHYtMnoiPjwvcGF0aD48L3N2Zz4=');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-cancel {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDIgNCIgZmlsbD0iIzc1NzU3NSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ieE1pZFlNaWQgbWVldCI+PHBhdGggZD0iTTEyIDJDNi40NyAyIDIgNi40NyAyIDEyczQuNDcgMTAgMTAgMTAgMTAtNC40NyAxMC0xMFMxNy41MyAyIDEyIDJ6bTUgMTMuNTlMMTUuNTkgMTcgMTIgMTMuNDEgOC40MSAxNyA3IDE1LjU5IDEwLjU5IDEyIDcgOC40MSA4LjQxIDcgMTIgMTAuNTkgMTUuNTkgNyAxNyA4LjQxIDEzLjQxIDEyIDE3IDE1LjU5eiIgLz48L3N2Zz4K');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-cancel-toolbar {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDIgNCIgZmlsbD0iI2ZmZmZmZiIgcHJlc2VydmVBc3BlY3RSYXRpbz0ieE1pZFlNaWQgbWVldCI+PHBhdGggZD0iTTEyIDJDNi40NyAyIDIgNi40NyAyIDEyczQuNDcgMTAgMTAgMTAgMTAtNC40NyAxMC0xMFMxNy41MyAyIDEyIDJ6bTUgMTMuNTlMMTUuNTkgMTcgMTIgMTMuNDEgOC40MSAxNyA3IDE1LjU5IDEwLjU5IDEyIDcgOC40MSA4LjQxIDcgMTIgMTAuNTkgMTUuNTkgNyAxNyA4LjQxIDEzLjQxIDEyIDE3IDE1LjU5eiIgLz48L3N2Zz4K');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-clear {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTkgNi40MUwxNy41OSA1IDEyIDEwLjU5IDYuNDEgNSA1IDYuNDEgMTAuNTkgMTIgNSAxNy41OSA2LjQxIDE5IDEyIDEzLjQxIDE3LjU5IDE5IDE5IDE3LjU5IDEzLjQxIDEyeiI+PC9wYXRoPjwvc3ZnPg==');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-delete-gray {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNNiAxOWMwIDEuMS45IDIgMiAyaDhjMS4xIDAgMi0uOSAyLTJWN0g2djEyek0xOSA0aC0zLjVsLTEtMWgtNWwtMSAxSDV2MmgxNFY0eiI+PC9wYXRoPjwvc3ZnPgo=');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-delete-white {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjZmZmZmZmIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNNiAxOWMwIDEuMS45IDIgMiAyaDhjMS4xIDAgMi0uOSAyLTJWN0g2djEyek0xOSA0aC0zLjVsLTEtMWgtNWwtMSAxSDV2MmgxNFY0eiI+PC9wYXRoPjwvc3ZnPgo=');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-expand-less {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIGZpbGw9IiM3NTc1NzUiIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIKICAgIHZpZXdib3g9IjAgMCAyNCAyNCI+CiAgPHBhdGggZD0iTTEyIDhsLTYgNiAxLjQxIDEuNDFMMTIgMTAuODNsNC41OSA0LjU4TDE4IDE0eiI+PC9wYXRoPgo8L3N2Zz4K');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-expand-more {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIGZpbGw9IiM3NTc1NzUiIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIKICAgIHZpZXdCb3g9IjAgMCAyNCAyNCI+CiAgPHBhdGggZD0iTTE2LjU5IDguNTlMMTIgMTMuMTcgNy40MSA4LjU5IDYgMTBsNiA2IDYtNnoiPjwvcGF0aD4KPC9zdmc+Cg==');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-external {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjYmRiZGJkIj48cGF0aCBkPSJNMTkgMTlINVY1aDdWM0g1YTIgMiAwIDAgMC0yIDJ2MTRhMiAyIDAgMCAwIDIgMmgxNGMxLjEgMCAyLS45IDItMnYtN2gtMnY3ek0xNCAzdjJoMy41OWwtOS44MyA5LjgzIDEuNDEgMS40MUwxOSA2LjQxVjEwaDJWM2gtN3oiLz48L3N2Zz4=');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-menu-white {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyMCIgaGVpZ2h0PSIyMCIgdmlld0JveD0iMCAwIDIwIDIwIiBmaWxsPSIjZmZmIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cmVjdCB4PSIyIiB5PSI0IiB3aWR0aD0iMTYiIGhlaWdodD0iMiI+PC9yZWN0PjxyZWN0IHg9IjIiIHk9IjkiIHdpZHRoPSIxNiIgaGVpZ2h0PSIyIj48L3JlY3Q+PHJlY3QgeD0iMiIgeT0iMTQiIHdpZHRoPSIxNiIgaGVpZ2h0PSIyIj48L3JlY3Q+PC9zdmc+');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-more-vert {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTIgOGMxLjEgMCAyLS45IDItMnMtLjktMi0yLTItMiAuOS0yIDIgLjkgMiAyIDJ6bTAgMmMtMS4xIDAtMiAuOS0yIDJzLjkgMiAyIDIgMi0uOSAyLTItLjktMi0yLTJ6bTAgNmMtMS4xIDAtMiAuOS0yIDJzLjkgMiAyIDIgMi0uOSAyLTItLjktMi0yLTJ6Ij48L3BhdGg+PC9zdmc+');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-refresh {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTcuNjUgNi4zNUMxNi4yIDQuOSAxNC4yMSA0IDEyIDRjLTQuNDIgMC03Ljk5IDMuNTgtNy45OSA4czMuNTcgOCA3Ljk5IDhjMy43MyAwIDYuODQtMi41NSA3LjczLTZoLTIuMDhjLS44MiAyLjMzLTMuMDQgNC01LjY1IDQtMy4zMSAwLTYtMi42OS02LTZzMi42OS02IDYtNmMxLjY2IDAgMy4xNC42OSA0LjIyIDEuNzhMMTMgMTFoN1Y0bC0yLjM1IDIuMzV6Ij48L3BhdGg+PC9zdmc+');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-settings {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTkuNDMgMTIuOThjLjA0LS4zMi4wNy0uNjQuMDctLjk4cy0uMDMtLjY2LS4wNy0uOThsMi4xMS0xLjY1Yy4xOS0uMTUuMjQtLjQyLjEyLS42NGwtMi0zLjQ2Yy0uMTItLjIyLS4zOS0uMy0uNjEtLjIybC0yLjQ5IDFjLS41Mi0uNC0xLjA4LS43My0xLjY5LS45OGwtLjM4LTIuNjVDMTQuNDYgMi4xOCAxNC4yNSAyIDE0IDJoLTRjLS4yNSAwLS40Ni4xOC0uNDkuNDJsLS4zOCAyLjY1Yy0uNjEuMjUtMS4xNy41OS0xLjY5Ljk4bC0yLjQ5LTFjLS4yMy0uMDktLjQ5IDAtLjYxLjIybC0yIDMuNDZjLS4xMy4yMi0uMDcuNDkuMTIuNjRsMi4xMSAxLjY1Yy0uMDQuMzItLjA3LjY1LS4wNy45OHMuMDMuNjYuMDcuOThsLTIuMTEgMS42NWMtLjE5LjE1LS4yNC40Mi0uMTIuNjRsMiAzLjQ2Yy4xMi4yMi4zOS4zLjYxLjIybDIuNDktMWMuNTIuNCAxLjA4LjczIDEuNjkuOThsLjM4IDIuNjVjLjAzLjI0LjI0LjQyLjQ5LjQyaDRjLjI1IDAgLjQ2LS4xOC40OS0uNDJsLjM4LTIuNjVjLjYxLS4yNSAxLjE3LS41OSAxLjY5LS45OGwyLjQ5IDFjLjIzLjA5LjQ5IDAgLjYxLS4yMmwyLTMuNDZjLjEyLS4yMi4wNy0uNDktLjEyLS42NGwtMi4xMS0xLjY1ek0xMiAxNS41Yy0xLjkzIDAtMy41LTEuNTctMy41LTMuNXMxLjU3LTMuNSAzLjUtMy41IDMuNSAxLjU3IDMuNSAzLjUtMS41NyAzLjUtMy41IDMuNXoiPjwvcGF0aD48L3N2Zz4=');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-search {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTUuNSAxNGgtLjc5bC0uMjgtLjI3QzE1LjQxIDEyLjU5IDE2IDExLjExIDE2IDkuNSAxNiA1LjkxIDEzLjA5IDMgOS41IDNTMyA1LjkxIDMgOS41IDUuOTEgMTYgOS41IDE2YzEuNjEgMCAzLjA5LS41OSA0LjIzLTEuNTdsLjI3LjI4di43OWw1IDQuOTlMMjAuNDkgMTlsLTQuOTktNXptLTYgMEM3LjAxIDE0IDUgMTEuOTkgNSA5LjVTNy4wMSA1IDkuNSA1IDE0IDcuMDEgMTQgOS41IDExLjk5IDE0IDkuNSAxNHoiPjwvcGF0aD48L3N2Zz4=');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-arrow-dropdown {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNNyAxMGw1IDUgNS01eiI+PC9wYXRoPjwvc3ZnPg==');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).subpage-arrow {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1Ij48cGF0aCBkPSJNMTAgN2w1IDUtNSA1eiIvPjwvc3ZnPg==');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-visibility {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTIgNC41QzcgNC41IDIuNzMgNy42MSAxIDEyYzEuNzMgNC4zOSA2IDcuNSAxMSA3LjVzOS4yNy0zLjExIDExLTcuNWMtMS43My00LjM5LTYtNy41LTExLTcuNXpNMTIgMTdjLTIuNzYgMC01LTIuMjQtNS01czIuMjQtNSA1LTUgNSAyLjI0IDUgNS0yLjI0IDUtNSA1em0wLThjLTEuNjYgMC0zIDEuMzQtMyAzczEuMzQgMyAzIDMgMy0xLjM0IDMtMy0xLjM0LTMtMy0zeiI+PC9wYXRoPjwvc3ZnPg==');
        }

        :-webkit-any(paper-icon-button-light, .cr-icon).icon-visibility-off {
            background-image: url('data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0IiBmaWxsPSIjNzU3NTc1IiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJ4TWlkWU1pZCBtZWV0Ij48cGF0aCBkPSJNMTIgN2MyLjc2IDAgNSAyLjI0IDUgNSAwIC42NS0uMTMgMS4yNi0uMzYgMS44M2wyLjkyIDIuOTJjMS41MS0xLjI2IDIuNy0yLjg5IDMuNDMtNC43NS0xLjczLTQuMzktNi03LjUtMTEtNy41LTEuNCAwLTIuNzQuMjUtMy45OC43bDIuMTYgMi4xNkMxMC43NCA3LjEzIDExLjM1IDcgMTIgN3pNMiA0LjI3bDIuMjggMi4yOC40Ni40NkMzLjA4IDguMyAxLjc4IDEwLjAyIDEgMTJjMS43MyA0LjM5IDYgNy41IDExIDcuNSAxLjU1IDAgMy4wMy0uMyA0LjM4LS44NGwuNDIuNDJMMTkuNzMgMjIgMjEgMjAuNzMgMy4yNyAzIDIgNC4yN3pNNy41MyA5LjhsMS41NSAxLjU1Yy0uMDUuMjEtLjA4LjQzLS4wOC42NSAwIDEuNjYgMS4zNCAzIDMgMyAuMjIgMCAuNDQtLjAzLjY1LS4wOGwxLjU1IDEuNTVjLS42Ny4zMy0xLjQxLjUzLTIuMi41My0yLjc2IDAtNS0yLjI0LTUtNSAwLS43OS4yLTEuNTMuNTMtMi4yem00LjMxLS43OGwzLjE1IDMuMTUuMDItLjE2YzAtMS42Ni0xLjM0LTMtMy0zbC0uMTcuMDF6Ii8+PC9zdmc+Cg==');
        }

        .action-button {
            background: var(--google-blue-500);
            color: white;
            --paper-button-flat-keyboard-focus_-_background:  rgb(58, 117, 215);;
        }

        .action-button[disabled] {
            opacity: .2;
        }

        .cancel-button {
            --paper-button-flat-keyboard-focus_-_background:  rgba(0, 0, 0, .12);;
            -webkit-margin-end: 8px;
            color: var(--paper-grey-600);
        }

        .action-button, .cancel-button {
            font-weight: 500;
            line-height: 154%;
            padding: 8px 16px;
        }

        [actionable] {
            cursor: var(--cr-actionable_-_cursor);
        }

        .subpage-arrow, .icon-external {
            display: none;
        }

        [actionable] :-webkit-any(.subpage-arrow, .icon-external), [actionable]:-webkit-any(.subpage-arrow, .icon-external) {
            display: block;
        }

        .hr {
            border-top: var(--cr-separator-line);
        }

        iron-list.cr-separators > *:not([first]) {
            border-top: var(--cr-separator-line);
        }

        [scrollable] {
            border-color: transparent;
            border-style: solid;
            border-width: 1px 0;
            overflow-y: auto;
        }

        [scrollable].is-scrolled {
            border-top-color: var(--google-grey-300);
        }

        [scrollable].can-scroll:not(.scrolled-to-bottom) {
            border-bottom-color: var(--google-grey-300);
        }

        [scrollable] iron-list > :not(.no-outline):focus {
        ;
            background-color: var(--cr-selectable-focus_-_background-color); outline: var(--cr-selectable-focus_-_outline);
        }

        .scroll-container {
            display: flex;
            flex-direction: column;
            min-height: 1px;
        }

        [selectable]:focus, [selectable] > :focus {
            background-color: var(--cr-selectable-focus_-_background-color); outline: var(--cr-selectable-focus_-_outline);
        }

        [selectable] > * {
            cursor: var(--cr-actionable_-_cursor);
        }

        #cr-container-shadow {
            box-shadow: var(--cr-container-shadow_-_box-shadow); height: var(--cr-container-shadow_-_height); left: var(--cr-container-shadow_-_left); margin-bottom: var(--cr-container-shadow_-_margin-bottom); opacity: var(--cr-container-shadow_-_opacity); pointer-events: var(--cr-container-shadow_-_pointer-events); position: var(--cr-container-shadow_-_position); right: var(--cr-container-shadow_-_right); top: var(--cr-container-shadow_-_top); transition: var(--cr-container-shadow_-_transition); z-index: var(--cr-container-shadow_-_z-index);
        }

        #cr-container-shadow.has-shadow {
            opacity: var(--cr-container-shadow-max-opacity);
        }</style>
        <cr-dialog id="dialog" no-cancel="">
            <div slot="title">
                错误
            </div>
            <div slot="body">
                未能加载 PDF 文档。
            </div>
            <div slot="button-container">
                <paper-button class="action-button" role="button" tabindex="0" animated="" aria-disabled="false" elevation="0">
                    重新加载
                </paper-button>
            </div>
        </cr-dialog>
    </viewer-error-screen>
    <script src="pdf_fitting_type.js"></script>
    <iron-a11y-announcer>
        <style scope="iron-a11y-announcer">:host {
            display: inline-block;
            position: fixed;
            clip: rect(0px,0px,0px,0px);
        }</style>
        <div aria-live="polite"></div>
    </iron-a11y-announcer>
    <script src="toolbar_manager.js"></script>
    <script src="viewport.js"></script>
    <script src="open_pdf_params_parser.js"></script>
    <script src="navigator.js"></script>
    <script src="viewport_scroller.js"></script>
    <script src="zoom_manager.js"></script>
    <script src="gesture_detector.js"></script>
    <script src="pdf_scripting_api.js"></script>
    <script src="chrome://resources/js/util.js"></script>
    <script src="browser_api.js"></script>
    <script src="coords_transformer.js"></script>
    <script src="metrics.js"></script>
    <script src="pdf.js"></script>
    <script src="main.js"></script>
    <embed id="plugin" type="application/x-google-chrome-pdf" src="file:///C:/Users/yf/Desktop/pdf/web/6d1f1ee3-860c-40f5-9587-a3875f41abda.pdf" stream-url="blob:chrome-extension://mhjfbmdgcfjbbpaeojofohoefgiehjai/f168703f-3615-4d7c-b526-b41db449fd6b" headers="" background-color="0xFF525659" top-toolbar-height="56" full-frame="">
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button class="btn-close btn" type="button" data-icon="close">
                <i class="fa fa-close">取消</i>
            </button>
        </li>
        <li>
                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_DETAIL_SHOW)%>?caseid=${caseid}&entity=${entity}"
                   data-toggle="dialog" class="btn btn-primary" data-width="800" data-height="600"
                    data-title="添加" >填写其他信息</a>
        </li>
    </ul>
</div>
